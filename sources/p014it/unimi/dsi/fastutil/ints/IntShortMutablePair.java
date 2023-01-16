package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntShortMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntShortMutablePair.class */
public class IntShortMutablePair implements IntShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected int left;
    protected short right;

    public IntShortMutablePair(int left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntShortMutablePair m693of(int left, short right) {
        return new IntShortMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntShortPair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntShortPair
    public IntShortMutablePair left(int l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntShortPair
    public IntShortMutablePair right(short r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntShortPair ? this.left == ((IntShortPair) other).leftInt() && this.right == ((IntShortPair) other).rightShort() : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + ((int) rightShort()) + ">";
    }
}
