package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntIntImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIntImmutablePair.class */
public class IntIntImmutablePair implements IntIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final int left;
    protected final int right;

    public IntIntImmutablePair(int left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntIntImmutablePair m731of(int left, int right) {
        return new IntIntImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIntPair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIntPair
    public int rightInt() {
        return this.right;
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
