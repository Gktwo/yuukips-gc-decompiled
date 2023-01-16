package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceObjectImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceObjectImmutablePair.class */
public class ReferenceObjectImmutablePair<K, V> implements ReferenceObjectPair<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final V right;

    public ReferenceObjectImmutablePair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K, V> ReferenceObjectImmutablePair<K, V> m485of(K left, V right) {
        return new ReferenceObjectImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        return other != null && (other instanceof Pair) && this.left == ((Pair) other).left() && Objects.equals(this.right, ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + (this.right == null ? 0 : this.right.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + right() + ">";
    }
}
