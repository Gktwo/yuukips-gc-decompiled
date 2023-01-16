package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceShortMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceShortMutablePair.class */
public class ReferenceShortMutablePair<K> implements ReferenceShortPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected short right;

    public ReferenceShortMutablePair(K left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceShortMutablePair<K> m468of(K left, short right) {
        return new ReferenceShortMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ReferenceShortMutablePair<K> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceShortPair
    public ReferenceShortMutablePair<K> right(short r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ReferenceShortPair ? this.left == ((ReferenceShortPair) other).left() && this.right == ((ReferenceShortPair) other).rightShort() : (other instanceof Pair) && this.left == ((Pair) other).left() && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + ((int) rightShort()) + ">";
    }
}
