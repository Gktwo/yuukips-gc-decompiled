package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongDoubleImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongDoubleImmutablePair.class */
public class LongDoubleImmutablePair implements LongDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final long left;
    protected final double right;

    public LongDoubleImmutablePair(long left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongDoubleImmutablePair m654of(long left, double right) {
        return new LongDoubleImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongDoublePair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof LongDoublePair ? this.left == ((LongDoublePair) other).leftLong() && this.right == ((LongDoublePair) other).rightDouble() : (other instanceof Pair) && Objects.equals(Long.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Double.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.long2int(this.left) * 19) + HashCommon.double2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftLong() + "," + rightDouble() + ">";
    }
}
