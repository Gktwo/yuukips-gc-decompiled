package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.expressions.impls.ConvertExpression;
import dev.morphia.aggregation.experimental.expressions.impls.ConvertType;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/TypeExpressions.class */
public final class TypeExpressions {
    protected TypeExpressions() {
    }

    public static Expression convert(Expression input, ConvertType to) {
        return new ConvertExpression(input, to);
    }

    public static Expression isNumber(Expression input) {
        return new Expression("$isNumber", input);
    }

    public static Expression toBool(Expression input) {
        return new Expression("$toBool", input);
    }

    public static Expression toDate(Expression input) {
        return new Expression("$toDate", input);
    }

    public static Expression toDecimal(Expression input) {
        return new Expression("$toDecimal", input);
    }

    public static Expression toDouble(Expression input) {
        return new Expression("$toDouble", input);
    }

    public static Expression toInt(Expression input) {
        return new Expression("$toInt", input);
    }

    public static Expression toLong(Expression input) {
        return new Expression("$toLong", input);
    }

    public static Expression toObjectId(Expression input) {
        return new Expression("$toObjectId", input);
    }

    public static Expression toString(Expression input) {
        return StringExpressions.toString(input);
    }

    public static Expression type(Expression input) {
        return new Expression("$type", input);
    }
}
