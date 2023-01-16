package p014it.unimi.dsi.fastutil.doubles;

import java.util.function.BinaryOperator;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBinaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBinaryOperator.class */
public interface DoubleBinaryOperator extends BinaryOperator<Double>, java.util.function.DoubleBinaryOperator {
    double apply(double d, double d2);

    @Override // java.util.function.DoubleBinaryOperator
    @Deprecated
    default double applyAsDouble(double x, double y) {
        return apply(x, y);
    }

    @Deprecated
    default Double apply(Double x, Double y) {
        return Double.valueOf(apply(x.doubleValue(), y.doubleValue()));
    }
}
