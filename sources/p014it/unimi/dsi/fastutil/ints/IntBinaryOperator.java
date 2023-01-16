package p014it.unimi.dsi.fastutil.ints;

import java.util.function.BinaryOperator;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.ints.IntBinaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBinaryOperator.class */
public interface IntBinaryOperator extends BinaryOperator<Integer>, java.util.function.IntBinaryOperator {
    int apply(int i, int i2);

    @Override // java.util.function.IntBinaryOperator
    @Deprecated
    default int applyAsInt(int x, int y) {
        return apply(x, y);
    }

    @Deprecated
    default Integer apply(Integer x, Integer y) {
        return Integer.valueOf(apply(x.intValue(), y.intValue()));
    }
}
