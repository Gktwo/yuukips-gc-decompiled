package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/TrigonometryExpressions.class */
public final class TrigonometryExpressions {
    private TrigonometryExpressions() {
    }

    public static Expression acos(Expression value) {
        return new Expression("$acos", value);
    }

    public static Expression acosh(Expression value) {
        return new Expression("$acosh", value);
    }

    public static Expression asin(Expression value) {
        return new Expression("$asin", value);
    }

    public static Expression asinh(Expression value) {
        return new Expression("$asinh", value);
    }

    public static Expression atan(Expression value) {
        return new Expression("$atan", value);
    }

    public static Expression atan2(Expression yValue, Expression xValue) {
        return new Expression("$atan2", List.of(yValue, xValue));
    }

    public static Expression atanh(Expression value) {
        return new Expression("$atanh", value);
    }

    public static Expression cos(Expression value) {
        return new Expression("$cos", value);
    }

    public static Expression cosh(Expression value) {
        return new Expression("$cosh", value);
    }

    public static Expression degreesToRadians(Expression value) {
        return new Expression("$degreesToRadians", value);
    }

    public static Expression radiansToDegrees(Expression value) {
        return new Expression("$radiansToDegrees", value);
    }

    public static Expression sin(Expression value) {
        return new Expression("$sin", value);
    }

    public static Expression sinh(Expression value) {
        return new Expression("$sinh", value);
    }

    public static Expression tan(Expression value) {
        return new Expression("$tan", value);
    }

    public static Expression tanh(Expression value) {
        return new Expression("$tanh", value);
    }
}
