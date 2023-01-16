package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatByteImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatByteImmutablePair.class */
public class FloatByteImmutablePair implements FloatBytePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final float left;
    protected final byte right;

    public FloatByteImmutablePair(float left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatByteImmutablePair m829of(float left, byte right) {
        return new FloatByteImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBytePair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof FloatBytePair ? this.left == ((FloatBytePair) other).leftFloat() && this.right == ((FloatBytePair) other).rightByte() : (other instanceof Pair) && Objects.equals(Float.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Byte.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.float2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftFloat() + "," + ((int) rightByte()) + ">";
    }
}
