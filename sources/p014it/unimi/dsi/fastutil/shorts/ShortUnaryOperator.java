package p014it.unimi.dsi.fastutil.shorts;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.shorts.ShortUnaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortUnaryOperator.class */
public interface ShortUnaryOperator extends UnaryOperator<Short>, IntUnaryOperator {
    short apply(short s);

    static ShortUnaryOperator identity() {
        return i -> {
            return i;
        };
    }

    static ShortUnaryOperator negation() {
        return i -> {
            return (short) (-i);
        };
    }

    @Override // java.util.function.IntUnaryOperator
    @Deprecated
    default int applyAsInt(int x) {
        return apply(SafeMath.safeIntToShort(x));
    }

    @Deprecated
    default Short apply(Short x) {
        return Short.valueOf(apply(x.shortValue()));
    }
}
