package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongDoubleMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongDoubleMutablePair.class */
public class LongDoubleMutablePair implements LongDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected long left;
    protected double right;

    public LongDoubleMutablePair(long left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongDoubleMutablePair m653of(long left, double right) {
        return new LongDoubleMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongDoublePair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongDoublePair
    public LongDoubleMutablePair left(long l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongDoublePair
    public LongDoubleMutablePair right(double r) {
        this.right = r;
        return this;
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
