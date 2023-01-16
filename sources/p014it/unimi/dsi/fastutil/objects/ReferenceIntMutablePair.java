package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceIntMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceIntMutablePair.class */
public class ReferenceIntMutablePair<K> implements ReferenceIntPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected int right;

    public ReferenceIntMutablePair(K left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceIntMutablePair<K> m500of(K left, int right) {
        return new ReferenceIntMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ReferenceIntMutablePair<K> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceIntPair
    public ReferenceIntMutablePair<K> right(int r) {
        this.right = r;
        return this;
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
