package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatShortMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatShortMutablePair.class */
public class FloatShortMutablePair implements FloatShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected float left;
    protected short right;

    public FloatShortMutablePair(float left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatShortMutablePair m778of(float left, short right) {
        return new FloatShortMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatShortPair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatShortPair
    public FloatShortMutablePair left(float l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatShortPair
    public FloatShortMutablePair right(short r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof FloatShortPair ? this.left == ((FloatShortPair) other).leftFloat() && this.right == ((FloatShortPair) other).rightShort() : (other instanceof Pair) && Objects.equals(Float.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.float2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftFloat() + "," + ((int) rightShort()) + ">";
    }
}
