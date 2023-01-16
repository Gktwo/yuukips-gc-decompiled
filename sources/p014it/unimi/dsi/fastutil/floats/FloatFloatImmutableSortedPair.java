package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatFloatImmutableSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatFloatImmutableSortedPair.class */
public class FloatFloatImmutableSortedPair extends FloatFloatImmutablePair implements FloatFloatSortedPair, Serializable {
    private static final long serialVersionUID = 0;

    private FloatFloatImmutableSortedPair(float left, float right) {
        super(left, right);
    }

    /* renamed from: of */
    public static FloatFloatImmutableSortedPair m819of(float left, float right) {
        return left <= right ? new FloatFloatImmutableSortedPair(left, right) : new FloatFloatImmutableSortedPair(right, left);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatFloatImmutablePair, java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof FloatFloatSortedPair ? this.left == ((FloatFloatSortedPair) other).leftFloat() && this.right == ((FloatFloatSortedPair) other).rightFloat() : (other instanceof SortedPair) && Objects.equals(Float.valueOf(this.left), ((SortedPair) other).left()) && Objects.equals(Float.valueOf(this.right), ((SortedPair) other).right());
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatFloatImmutablePair, java.lang.Object
    public String toString() {
        return "{" + leftFloat() + "," + rightFloat() + "}";
    }
}
