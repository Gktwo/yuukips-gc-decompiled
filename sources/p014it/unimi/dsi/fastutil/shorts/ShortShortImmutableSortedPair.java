package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortShortImmutableSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortShortImmutableSortedPair.class */
public class ShortShortImmutableSortedPair extends ShortShortImmutablePair implements ShortShortSortedPair, Serializable {
    private static final long serialVersionUID = 0;

    private ShortShortImmutableSortedPair(short left, short right) {
        super(left, right);
    }

    /* renamed from: of */
    public static ShortShortImmutableSortedPair m385of(short left, short right) {
        return left <= right ? new ShortShortImmutableSortedPair(left, right) : new ShortShortImmutableSortedPair(right, left);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortShortImmutablePair, java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortShortSortedPair ? this.left == ((ShortShortSortedPair) other).leftShort() && this.right == ((ShortShortSortedPair) other).rightShort() : (other instanceof SortedPair) && Objects.equals(Short.valueOf(this.left), ((SortedPair) other).left()) && Objects.equals(Short.valueOf(this.right), ((SortedPair) other).right());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortShortImmutablePair, java.lang.Object
    public String toString() {
        return "{" + ((int) leftShort()) + "," + ((int) rightShort()) + "}";
    }
}
