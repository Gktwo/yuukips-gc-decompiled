package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntFloatImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntFloatImmutablePair.class */
public class IntFloatImmutablePair implements IntFloatPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final int left;
    protected final float right;

    public IntFloatImmutablePair(int left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntFloatImmutablePair m736of(int left, float right) {
        return new IntFloatImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntFloatPair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntFloatPair ? this.left == ((IntFloatPair) other).leftInt() && this.right == ((IntFloatPair) other).rightFloat() : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + rightFloat() + ">";
    }
}
