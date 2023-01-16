package p014it.unimi.dsi.fastutil.floats;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import p014it.unimi.dsi.fastutil.SafeMath;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.floats.FloatBinaryOperator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBinaryOperator.class */
public interface FloatBinaryOperator extends BinaryOperator<Float>, DoubleBinaryOperator {
    float apply(float f, float f2);

    @Override // java.util.function.DoubleBinaryOperator
    @Deprecated
    default double applyAsDouble(double x, double y) {
        return (double) apply(SafeMath.safeDoubleToFloat(x), SafeMath.safeDoubleToFloat(y));
    }

    @Deprecated
    default Float apply(Float x, Float y) {
        return Float.valueOf(apply(x.floatValue(), y.floatValue()));
    }
}
