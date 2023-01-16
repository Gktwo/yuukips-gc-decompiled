package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleDoubleImmutableSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleDoubleImmutableSortedPair.class */
public class DoubleDoubleImmutableSortedPair extends DoubleDoubleImmutablePair implements DoubleDoubleSortedPair, Serializable {
    private static final long serialVersionUID = 0;

    private DoubleDoubleImmutableSortedPair(double left, double right) {
        super(left, right);
    }

    /* renamed from: of */
    public static DoubleDoubleImmutableSortedPair m906of(double left, double right) {
        return left <= right ? new DoubleDoubleImmutableSortedPair(left, right) : new DoubleDoubleImmutableSortedPair(right, left);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleDoubleImmutablePair, java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleDoubleSortedPair ? this.left == ((DoubleDoubleSortedPair) other).leftDouble() && this.right == ((DoubleDoubleSortedPair) other).rightDouble() : (other instanceof SortedPair) && Objects.equals(Double.valueOf(this.left), ((SortedPair) other).left()) && Objects.equals(Double.valueOf(this.right), ((SortedPair) other).right());
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleDoubleImmutablePair, java.lang.Object
    public String toString() {
        return "{" + leftDouble() + "," + rightDouble() + "}";
    }
}
