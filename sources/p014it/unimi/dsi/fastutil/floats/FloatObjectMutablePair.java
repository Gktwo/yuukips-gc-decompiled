package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatObjectMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatObjectMutablePair.class */
public class FloatObjectMutablePair<V> implements FloatObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected float left;
    protected V right;

    public FloatObjectMutablePair(float left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> FloatObjectMutablePair<V> m796of(float left, V right) {
        return new FloatObjectMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatObjectPair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatObjectPair
    public FloatObjectMutablePair<V> left(float l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public FloatObjectMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof FloatObjectPair ? this.left == ((FloatObjectPair) other).leftFloat() && Objects.equals(this.right, ((FloatObjectPair) other).right()) : (other instanceof Pair) && Objects.equals(Float.valueOf(this.left), ((Pair) other).left()) && Objects.equals(this.right, ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.float2int(this.left) * 19) + (this.right == null ? 0 : this.right.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftFloat() + "," + right() + ">";
    }
}
