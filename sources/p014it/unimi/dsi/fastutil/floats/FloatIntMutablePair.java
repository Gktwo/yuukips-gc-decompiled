package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatIntMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatIntMutablePair.class */
public class FloatIntMutablePair implements FloatIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected float left;
    protected int right;

    public FloatIntMutablePair(float left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatIntMutablePair m812of(float left, int right) {
        return new FloatIntMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIntPair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIntPair
    public FloatIntMutablePair left(float l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatIntPair
    public FloatIntMutablePair right(int r) {
        this.right = r;
        return this;
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
