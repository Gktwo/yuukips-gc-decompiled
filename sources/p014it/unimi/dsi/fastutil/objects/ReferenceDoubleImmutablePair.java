package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceDoubleImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceDoubleImmutablePair.class */
public class ReferenceDoubleImmutablePair<K> implements ReferenceDoublePair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final double right;

    public ReferenceDoubleImmutablePair(K left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceDoubleImmutablePair<K> m509of(K left, double right) {
        return new ReferenceDoubleImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ReferenceDoublePair ? this.left == ((ReferenceDoublePair) other).left() && this.right == ((ReferenceDoublePair) other).rightDouble() : (other instanceof Pair) && this.left == ((Pair) other).left() && Objects.equals(Double.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + HashCommon.double2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightDouble() + ">";
    }
}
