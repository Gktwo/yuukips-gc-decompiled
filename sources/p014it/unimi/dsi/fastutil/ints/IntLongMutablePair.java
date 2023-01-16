package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntLongMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntLongMutablePair.class */
public class IntLongMutablePair implements IntLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected int left;
    protected long right;

    public IntLongMutablePair(int left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntLongMutablePair m715of(int left, long right) {
        return new IntLongMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntLongPair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntLongPair
    public IntLongMutablePair left(int l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntLongPair
    public IntLongMutablePair right(long r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntLongPair ? this.left == ((IntLongPair) other).leftInt() && this.right == ((IntLongPair) other).rightLong() : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Long.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.long2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + rightLong() + ">";
    }
}
