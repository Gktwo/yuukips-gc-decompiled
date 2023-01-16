package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceReferenceMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceReferenceMutablePair.class */
public class ReferenceReferenceMutablePair<K, V> implements ReferenceReferencePair<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected V right;

    public ReferenceReferenceMutablePair(K left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K, V> ReferenceReferenceMutablePair<K, V> m476of(K left, V right) {
        return new ReferenceReferenceMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ReferenceReferenceMutablePair<K, V> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ReferenceReferenceMutablePair<K, V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        return other != null && (other instanceof Pair) && this.left == ((Pair) other).left() && this.right == ((Pair) other).right();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + right() + ">";
    }
}
