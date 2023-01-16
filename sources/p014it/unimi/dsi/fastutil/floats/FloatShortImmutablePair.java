package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatShortImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatShortImmutablePair.class */
public class FloatShortImmutablePair implements FloatShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final float left;
    protected final short right;

    public FloatShortImmutablePair(float left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatShortImmutablePair m779of(float left, short right) {
        return new FloatShortImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatShortPair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatShortPair
    public short rightShort() {
        return this.right;
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
