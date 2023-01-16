package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatIntImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIntImmutablePair.class */
public class FloatIntImmutablePair implements FloatIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final float left;
    protected final int right;

    public FloatIntImmutablePair(float left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatIntImmutablePair m813of(float left, int right) {
        return new FloatIntImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIntPair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof FloatIntPair ? this.left == ((FloatIntPair) other).leftFloat() && this.right == ((FloatIntPair) other).rightInt() : (other instanceof Pair) && Objects.equals(Float.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Integer.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.float2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftFloat() + "," + rightInt() + ">";
    }
}
