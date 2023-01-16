package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntIntImmutableSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntIntImmutableSortedPair.class */
public class IntIntImmutableSortedPair extends IntIntImmutablePair implements IntIntSortedPair, Serializable {
    private static final long serialVersionUID = 0;

    private IntIntImmutableSortedPair(int left, int right) {
        super(left, right);
    }

    /* renamed from: of */
    public static IntIntImmutableSortedPair m730of(int left, int right) {
        return left <= right ? new IntIntImmutableSortedPair(left, right) : new IntIntImmutableSortedPair(right, left);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIntImmutablePair, java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntIntSortedPair ? this.left == ((IntIntSortedPair) other).leftInt() && this.right == ((IntIntSortedPair) other).rightInt() : (other instanceof SortedPair) && Objects.equals(Integer.valueOf(this.left), ((SortedPair) other).left()) && Objects.equals(Integer.valueOf(this.right), ((SortedPair) other).right());
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntIntImmutablePair, java.lang.Object
    public String toString() {
        return "{" + leftInt() + "," + rightInt() + "}";
    }
}
