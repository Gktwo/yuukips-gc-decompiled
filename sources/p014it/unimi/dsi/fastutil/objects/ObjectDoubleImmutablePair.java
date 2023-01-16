package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectDoubleImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectDoubleImmutablePair.class */
public class ObjectDoubleImmutablePair<K> implements ObjectDoublePair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final double right;

    public ObjectDoubleImmutablePair(K left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectDoubleImmutablePair<K> m569of(K left, double right) {
        return new ObjectDoubleImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ObjectDoublePair ? Objects.equals(this.left, ((ObjectDoublePair) other).left()) && this.right == ((ObjectDoublePair) other).rightDouble() : (other instanceof Pair) && Objects.equals(this.left, ((Pair) other).left()) && Objects.equals(Double.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left == null ? 0 : this.left.hashCode()) * 19) + HashCommon.double2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightDouble() + ">";
    }
}
