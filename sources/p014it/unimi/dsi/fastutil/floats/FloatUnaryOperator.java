package p014it.unimi.dsi.fastutil.floats;

import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.floats.FloatUnaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatUnaryOperator.class */
public interface FloatUnaryOperator extends UnaryOperator<Float>, DoubleUnaryOperator {
    float apply(float f);

    static FloatUnaryOperator identity() {
        return i -> {
            return i;
        };
    }

    static FloatUnaryOperator negation() {
        return i -> {
            return -i;
        };
    }

    @Override // java.util.function.DoubleUnaryOperator
    @Deprecated
    default double applyAsDouble(double x) {
        return (double) apply(SafeMath.safeDoubleToFloat(x));
    }

    @Deprecated
    default Float apply(Float x) {
        return Float.valueOf(apply(x.floatValue()));
    }
}
