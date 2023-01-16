package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortShortSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortShortSortedPair.class */
public interface ShortShortSortedPair extends ShortShortPair, SortedPair<Short>, Serializable {
    /* renamed from: of */
    static ShortShortSortedPair m382of(short left, short right) {
        return ShortShortImmutableSortedPair.m385of(left, right);
    }

    default boolean contains(short e) {
        return e == leftShort() || e == rightShort();
    }

    @Override // p014it.unimi.dsi.fastutil.SortedPair
    @Deprecated
    default boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        return contains(((Short) o).shortValue());
    }
}
