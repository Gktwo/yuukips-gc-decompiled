package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectIntImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIntImmutablePair.class */
public class ObjectIntImmutablePair<K> implements ObjectIntPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final int right;

    public ObjectIntImmutablePair(K left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectIntImmutablePair<K> m561of(K left, int right) {
        return new ObjectIntImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ObjectIntPair ? Objects.equals(this.left, ((ObjectIntPair) other).left()) && this.right == ((ObjectIntPair) other).rightInt() : (other instanceof Pair) && Objects.equals(this.left, ((Pair) other).left()) && Objects.equals(Integer.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left == null ? 0 : this.left.hashCode()) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightInt() + ">";
    }
}
