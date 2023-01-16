package p014it.unimi.dsi.fastutil.doubles;

import java.util.function.UnaryOperator;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleUnaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleUnaryOperator.class */
public interface DoubleUnaryOperator extends UnaryOperator<Double>, java.util.function.DoubleUnaryOperator {
    double apply(double d);

    static DoubleUnaryOperator identity() {
        return i -> {
            return i;
        };
    }

    static DoubleUnaryOperator negation() {
        return i -> {
            return -i;
        };
    }

    @Override // java.util.function.DoubleUnaryOperator
    @Deprecated
    default double applyAsDouble(double x) {
        return apply(x);
    }

    @Deprecated
    default Double apply(Double x) {
        return Double.valueOf(apply(x.doubleValue()));
    }
}
