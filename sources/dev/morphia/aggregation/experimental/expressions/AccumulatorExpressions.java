package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.expressions.impls.Accumulator;
import dev.morphia.aggregation.experimental.expressions.impls.AccumulatorExpression;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.expressions.impls.FunctionExpression;
import dev.morphia.aggregation.experimental.expressions.impls.Push;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/AccumulatorExpressions.class */
public final class AccumulatorExpressions {
    private AccumulatorExpressions() {
    }

    public static AccumulatorExpression accumulator(String initFunction, String accumulateFunction, List<Expression> accumulateArgs, String mergeFunction) {
        return new AccumulatorExpression(initFunction, accumulateFunction, accumulateArgs, mergeFunction);
    }

    public static Expression addToSet(Expression value) {
        return new Expression("$addToSet", value);
    }

    public static Expression avg(Expression value, Expression... additional) {
        List<Expression> expressions = new ArrayList<>();
        expressions.add(value);
        expressions.addAll(Arrays.asList(additional));
        return new Accumulator("$avg", expressions);
    }

    public static Expression first(Expression value) {
        return new Expression("$first", value);
    }

    public static Expression function(String body, Expression... args) {
        return new FunctionExpression(body, Arrays.asList(args));
    }

    public static Expression last(Expression value) {
        return new Expression("$last", value);
    }

    public static Expression max(Expression value) {
        return new Expression("$max", value);
    }

    public static Expression min(Expression value) {
        return new Expression("$min", value);
    }

    public static Expression push(Expression value) {
        return new Expression("$push", value);
    }

    public static Push push() {
        return new Push();
    }

    public static Expression stdDevPop(Expression value, Expression... additional) {
        List<Expression> expressions = new ArrayList<>();
        expressions.add(value);
        expressions.addAll(Arrays.asList(additional));
        return new Accumulator("$stdDevPop", expressions);
    }

    public static Expression stdDevSamp(Expression value, Expression... additional) {
        List<Expression> expressions = new ArrayList<>();
        expressions.add(value);
        expressions.addAll(Arrays.asList(additional));
        return new Accumulator("$stdDevSamp", expressions);
    }

    public static Expression sum(Expression first, Expression... additional) {
        List<Expression> expressions = new ArrayList<>();
        expressions.add(first);
        expressions.addAll(Arrays.asList(additional));
        return new Accumulator("$sum", expressions);
    }
}
