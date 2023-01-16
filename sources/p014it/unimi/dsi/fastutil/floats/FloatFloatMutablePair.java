package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatFloatMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatFloatMutablePair.class */
public class FloatFloatMutablePair implements FloatFloatPair, Serializable {
    private static final long serialVersionUID = 0;
    protected float left;
    protected float right;

    public FloatFloatMutablePair(float left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatFloatMutablePair m818of(float left, float right) {
        return new FloatFloatMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatFloatPair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatFloatPair
    public FloatFloatMutablePair left(float l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatFloatPair
    public FloatFloatMutablePair right(float r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof FloatFloatPair ? this.left == ((FloatFloatPair) other).leftFloat() && this.right == ((FloatFloatPair) other).rightFloat() : (other instanceof Pair) && Objects.equals(Float.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.float2int(this.left) * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftFloat() + "," + rightFloat() + ">";
    }
}
