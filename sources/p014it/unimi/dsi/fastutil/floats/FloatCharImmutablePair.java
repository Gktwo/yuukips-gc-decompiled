package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatCharImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatCharImmutablePair.class */
public class FloatCharImmutablePair implements FloatCharPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final float left;
    protected final char right;

    public FloatCharImmutablePair(float left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatCharImmutablePair m826of(float left, char right) {
        return new FloatCharImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCharPair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof FloatCharPair ? this.left == ((FloatCharPair) other).leftFloat() && this.right == ((FloatCharPair) other).rightChar() : (other instanceof Pair) && Objects.equals(Float.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.float2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftFloat() + "," + rightChar() + ">";
    }
}
