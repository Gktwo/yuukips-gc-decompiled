package p014it.unimi.dsi.fastutil.floats;

import java.io.Serializable;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatFloatSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatFloatSortedPair.class */
public interface FloatFloatSortedPair extends FloatFloatPair, SortedPair<Float>, Serializable {
    /* renamed from: of */
    static FloatFloatSortedPair m816of(float left, float right) {
        return FloatFloatImmutableSortedPair.m819of(left, right);
    }

    default boolean contains(float e) {
        return e == leftFloat() || e == rightFloat();
    }

    @Override // p014it.unimi.dsi.fastutil.SortedPair
    @Deprecated
    default boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        return contains(((Float) o).floatValue());
    }
}
