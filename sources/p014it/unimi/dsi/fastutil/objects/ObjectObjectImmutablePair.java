package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectObjectImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectObjectImmutablePair.class */
public class ObjectObjectImmutablePair<K, V> implements Pair<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final V right;

    public ObjectObjectImmutablePair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K, V> ObjectObjectImmutablePair<K, V> m545of(K left, V right) {
        return new ObjectObjectImmutablePair<>(left, right);
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
        return other != null && (other instanceof Pair) && Objects.equals(this.left, ((Pair) other).left()) && Objects.equals(this.right, ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left == null ? 0 : this.left.hashCode()) * 19) + (this.right == null ? 0 : this.right.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + right() + ">";
    }
}
