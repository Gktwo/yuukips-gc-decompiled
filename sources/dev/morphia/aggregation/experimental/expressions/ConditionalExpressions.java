package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.expressions.impls.IfNull;
import dev.morphia.aggregation.experimental.expressions.impls.SwitchExpression;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/ConditionalExpressions.class */
public class ConditionalExpressions {
    private ConditionalExpressions() {
    }

    public static Expression condition(Expression condition, Expression then, Expression otherwise) {
        return new Expression("$cond", List.of(condition, then, otherwise));
    }

    public static IfNull ifNull() {
        return new IfNull();
    }

    public static SwitchExpression switchExpression() {
        return new SwitchExpression();
    }
}
