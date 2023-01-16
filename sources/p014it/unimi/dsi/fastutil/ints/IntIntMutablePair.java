package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntIntMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIntMutablePair.class */
public class IntIntMutablePair implements IntIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected int left;
    protected int right;

    public IntIntMutablePair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntIntMutablePair m729of(int left, int right) {
        return new IntIntMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIntPair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIntPair
    public IntIntMutablePair left(int l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIntPair
    public IntIntMutablePair right(int r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntIntPair ? this.left == ((IntIntPair) other).leftInt() && this.right == ((IntIntPair) other).rightInt() : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Integer.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + rightInt() + ">";
    }
}
