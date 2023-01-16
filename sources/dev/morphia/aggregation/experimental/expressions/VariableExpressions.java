package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.expressions.impls.LetExpression;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/VariableExpressions.class */
public final class VariableExpressions {
    private VariableExpressions() {
    }

    public static LetExpression let(Expression in) {
        return new LetExpression(in);
    }
}
