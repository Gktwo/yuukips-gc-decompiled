package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatReferenceImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatReferenceImmutablePair.class */
public class FloatReferenceImmutablePair<V> implements FloatReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final float left;
    protected final V right;

    public FloatReferenceImmutablePair(float left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> FloatReferenceImmutablePair<V> m787of(float left, V right) {
        return new FloatReferenceImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatReferencePair
    public float leftFloat() {
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
        return other instanceof FloatReferencePair ? this.left == ((FloatReferencePair) other).leftFloat() && this.right == ((FloatReferencePair) other).right() : (other instanceof Pair) && Objects.equals(Float.valueOf(this.left), ((Pair) other).left()) && this.right == ((Pair) other).right();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.float2int(this.left) * 19) + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftFloat() + "," + right() + ">";
    }
}
