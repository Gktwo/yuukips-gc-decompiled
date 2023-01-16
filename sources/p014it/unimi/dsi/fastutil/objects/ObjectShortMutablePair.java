package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectShortMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectShortMutablePair.class */
public class ObjectShortMutablePair<K> implements ObjectShortPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected short right;

    public ObjectShortMutablePair(K left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectShortMutablePair<K> m527of(K left, short right) {
        return new ObjectShortMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ObjectShortMutablePair<K> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectShortPair
    public ObjectShortMutablePair<K> right(short r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ObjectShortPair ? Objects.equals(this.left, ((ObjectShortPair) other).left()) && this.right == ((ObjectShortPair) other).rightShort() : (other instanceof Pair) && Objects.equals(this.left, ((Pair) other).left()) && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left == null ? 0 : this.left.hashCode()) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + ((int) rightShort()) + ">";
    }
}
