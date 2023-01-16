package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectDoubleMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectDoubleMutablePair.class */
public class ObjectDoubleMutablePair<K> implements ObjectDoublePair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected double right;

    public ObjectDoubleMutablePair(K left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectDoubleMutablePair<K> m568of(K left, double right) {
        return new ObjectDoubleMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ObjectDoubleMutablePair<K> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectDoublePair
    public ObjectDoubleMutablePair<K> right(double r) {
        this.right = r;
        return this;
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
