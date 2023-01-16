package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongIntImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIntImmutablePair.class */
public class LongIntImmutablePair implements LongIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final long left;
    protected final int right;

    public LongIntImmutablePair(long left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongIntImmutablePair m646of(long left, int right) {
        return new LongIntImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIntPair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof LongIntPair ? this.left == ((LongIntPair) other).leftLong() && this.right == ((LongIntPair) other).rightInt() : (other instanceof Pair) && Objects.equals(Long.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Integer.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.long2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftLong() + "," + rightInt() + ">";
    }
}
