package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceIntImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceIntImmutablePair.class */
public class ReferenceIntImmutablePair<K> implements ReferenceIntPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final int right;

    public ReferenceIntImmutablePair(K left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceIntImmutablePair<K> m501of(K left, int right) {
        return new ReferenceIntImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ReferenceIntPair ? this.left == ((ReferenceIntPair) other).left() && this.right == ((ReferenceIntPair) other).rightInt() : (other instanceof Pair) && this.left == ((Pair) other).left() && Objects.equals(Integer.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightInt() + ">";
    }
}
