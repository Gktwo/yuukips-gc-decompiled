package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatLongImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLongImmutablePair.class */
public class FloatLongImmutablePair implements FloatLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final float left;
    protected final long right;

    public FloatLongImmutablePair(float left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatLongImmutablePair m800of(float left, long right) {
        return new FloatLongImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatLongPair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof FloatLongPair ? this.left == ((FloatLongPair) other).leftFloat() && this.right == ((FloatLongPair) other).rightLong() : (other instanceof Pair) && Objects.equals(Float.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Long.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.float2int(this.left) * 19) + HashCommon.long2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftFloat() + "," + rightLong() + ">";
    }
}
