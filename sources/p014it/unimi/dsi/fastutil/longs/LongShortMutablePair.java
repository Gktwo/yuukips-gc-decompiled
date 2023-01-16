package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongShortMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongShortMutablePair.class */
public class LongShortMutablePair implements LongShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected long left;
    protected short right;

    public LongShortMutablePair(long left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongShortMutablePair m608of(long left, short right) {
        return new LongShortMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongShortPair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongShortPair
    public LongShortMutablePair left(long l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongShortPair
    public LongShortMutablePair right(short r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof LongShortPair ? this.left == ((LongShortPair) other).leftLong() && this.right == ((LongShortPair) other).rightShort() : (other instanceof Pair) && Objects.equals(Long.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.long2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftLong() + "," + ((int) rightShort()) + ">";
    }
}
