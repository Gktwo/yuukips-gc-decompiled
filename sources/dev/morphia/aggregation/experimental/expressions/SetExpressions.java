package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/SetExpressions.class */
public final class SetExpressions {
    private SetExpressions() {
    }

    public static Expression allElementsTrue(Expression first, Expression... additional) {
        return new Expression("$allElementsTrue", Expressions.toList(first, additional));
    }

    public static Expression anyElementTrue(Expression first, Expression... additional) {
        return new Expression("$anyElementTrue", Expressions.toList(first, additional));
    }

    public static Expression setDifference(Expression first, Expression second) {
        return new Expression("$setDifference", List.of(first, second));
    }

    public static Expression setEquals(Expression first, Expression... additional) {
        return new Expression("$setEquals", Expressions.toList(first, additional));
    }

    public static Expression setIntersection(Expression first, Expression... additional) {
        return new Expression("$setIntersection", Expressions.toList(first, additional));
    }

    public static Expression setIsSubset(Expression first, Expression second) {
        return new Expression("$setIsSubset", List.of(first, second));
    }

    public static Expression setUnion(Expression first, Expression... additional) {
        return new Expression("$setUnion", Expressions.toList(first, additional));
    }
}
