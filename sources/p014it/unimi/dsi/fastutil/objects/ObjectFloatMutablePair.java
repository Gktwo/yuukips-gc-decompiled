package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectFloatMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectFloatMutablePair.class */
public class ObjectFloatMutablePair<K> implements ObjectFloatPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected float right;

    public ObjectFloatMutablePair(K left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectFloatMutablePair<K> m565of(K left, float right) {
        return new ObjectFloatMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ObjectFloatMutablePair<K> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectFloatPair
    public ObjectFloatMutablePair<K> right(float r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ObjectFloatPair ? Objects.equals(this.left, ((ObjectFloatPair) other).left()) && this.right == ((ObjectFloatPair) other).rightFloat() : (other instanceof Pair) && Objects.equals(this.left, ((Pair) other).left()) && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left == null ? 0 : this.left.hashCode()) * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightFloat() + ">";
    }
}
