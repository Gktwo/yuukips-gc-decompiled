package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortFloatMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortFloatMutablePair.class */
public class ShortFloatMutablePair implements ShortFloatPair, Serializable {
    private static final long serialVersionUID = 0;
    protected short left;
    protected float right;

    public ShortFloatMutablePair(short left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ShortFloatMutablePair m425of(short left, float right) {
        return new ShortFloatMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortFloatPair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortFloatPair
    public ShortFloatMutablePair left(short l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortFloatPair
    public ShortFloatMutablePair right(float r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortFloatPair ? this.left == ((ShortFloatPair) other).leftShort() && this.right == ((ShortFloatPair) other).rightFloat() : (other instanceof Pair) && Objects.equals(Short.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftShort()) + "," + rightFloat() + ">";
    }
}
