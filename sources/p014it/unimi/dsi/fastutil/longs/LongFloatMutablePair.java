package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongFloatMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongFloatMutablePair.class */
public class LongFloatMutablePair implements LongFloatPair, Serializable {
    private static final long serialVersionUID = 0;
    protected long left;
    protected float right;

    public LongFloatMutablePair(long left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongFloatMutablePair m650of(long left, float right) {
        return new LongFloatMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongFloatPair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongFloatPair
    public LongFloatMutablePair left(long l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongFloatPair
    public LongFloatMutablePair right(float r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof LongFloatPair ? this.left == ((LongFloatPair) other).leftLong() && this.right == ((LongFloatPair) other).rightFloat() : (other instanceof Pair) && Objects.equals(Long.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.long2int(this.left) * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftLong() + "," + rightFloat() + ">";
    }
}
