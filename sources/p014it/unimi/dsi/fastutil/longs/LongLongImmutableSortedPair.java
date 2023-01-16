package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongLongImmutableSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLongImmutableSortedPair.class */
public class LongLongImmutableSortedPair extends LongLongImmutablePair implements LongLongSortedPair, Serializable {
    private static final long serialVersionUID = 0;

    private LongLongImmutableSortedPair(long left, long right) {
        super(left, right);
    }

    /* renamed from: of */
    public static LongLongImmutableSortedPair m632of(long left, long right) {
        return left <= right ? new LongLongImmutableSortedPair(left, right) : new LongLongImmutableSortedPair(right, left);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongLongImmutablePair, java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof LongLongSortedPair ? this.left == ((LongLongSortedPair) other).leftLong() && this.right == ((LongLongSortedPair) other).rightLong() : (other instanceof SortedPair) && Objects.equals(Long.valueOf(this.left), ((SortedPair) other).left()) && Objects.equals(Long.valueOf(this.right), ((SortedPair) other).right());
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongLongImmutablePair, java.lang.Object
    public String toString() {
        return "{" + leftLong() + "," + rightLong() + "}";
    }
}
