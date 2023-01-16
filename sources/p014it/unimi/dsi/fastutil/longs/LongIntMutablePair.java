package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongIntMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongIntMutablePair.class */
public class LongIntMutablePair implements LongIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected long left;
    protected int right;

    public LongIntMutablePair(long left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongIntMutablePair m645of(long left, int right) {
        return new LongIntMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIntPair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIntPair
    public LongIntMutablePair left(long l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongIntPair
    public LongIntMutablePair right(int r) {
        this.right = r;
        return this;
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
