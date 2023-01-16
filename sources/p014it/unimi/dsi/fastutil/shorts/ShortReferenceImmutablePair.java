package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortReferenceImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortReferenceImmutablePair.class */
public class ShortReferenceImmutablePair<V> implements ShortReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final short left;
    protected final V right;

    public ShortReferenceImmutablePair(short left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> ShortReferenceImmutablePair<V> m395of(short left, V right) {
        return new ShortReferenceImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortReferencePair
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
