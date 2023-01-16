package p014it.unimi.dsi.fastutil.shorts;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.shorts.ShortBinaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBinaryOperator.class */
public interface ShortBinaryOperator extends BinaryOperator<Short>, IntBinaryOperator {
    short apply(short s, short s2);

    @Override // java.util.function.IntBinaryOperator
    @Deprecated
    default int applyAsInt(int x, int y) {
        return apply(SafeMath.safeIntToShort(x), SafeMath.safeIntToShort(y));
    }

    @Deprecated
    default Short apply(Short x, Short y) {
        return Short.valueOf(apply(x.shortValue(), y.shortValue()));
    }
}
