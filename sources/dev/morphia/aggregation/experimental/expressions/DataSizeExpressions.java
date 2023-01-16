package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/DataSizeExpressions.class */
public final class DataSizeExpressions {
    private DataSizeExpressions() {
    }

    public static Expression binarySize(Expression expression) {
        return new Expression("$binarySize", expression);
    }

    public static Expression bsonSize(Expression expression) {
        return new Expression("$bsonSize", expression);
    }
}
