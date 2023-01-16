package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatLongMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatLongMutablePair.class */
public class FloatLongMutablePair implements FloatLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected float left;
    protected long right;

    public FloatLongMutablePair(float left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatLongMutablePair m799of(float left, long right) {
        return new FloatLongMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatLongPair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatLongPair
    public FloatLongMutablePair left(float l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatLongPair
    public FloatLongMutablePair right(long r) {
        this.right = r;
        return this;
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
