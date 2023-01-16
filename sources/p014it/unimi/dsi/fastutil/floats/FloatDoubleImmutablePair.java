package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatDoubleImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatDoubleImmutablePair.class */
public class FloatDoubleImmutablePair implements FloatDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final float left;
    protected final double right;

    public FloatDoubleImmutablePair(float left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatDoubleImmutablePair m823of(float left, double right) {
        return new FloatDoubleImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatDoublePair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof FloatDoublePair ? this.left == ((FloatDoublePair) other).leftFloat() && this.right == ((FloatDoublePair) other).rightDouble() : (other instanceof Pair) && Objects.equals(Float.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Double.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.float2int(this.left) * 19) + HashCommon.double2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftFloat() + "," + rightDouble() + ">";
    }
}
