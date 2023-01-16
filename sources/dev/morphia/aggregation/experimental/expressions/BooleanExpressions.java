package dev.morphia.aggregation.experimental.expressions;

import com.mongodb.QueryOperators;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/BooleanExpressions.class */
public final class BooleanExpressions {
    private BooleanExpressions() {
    }

    public static Expression and(Expression first, Expression... additional) {
        return new Expression(QueryOperators.AND, Expressions.toList(first, additional));
    }

    public static Expression not(Expression value) {
        return new Expression(QueryOperators.NOT, List.of(value));
    }

    /* renamed from: or */
    public static Expression m1264or(Expression first, Expression... additional) {
        return new Expression(QueryOperators.f428OR, Expressions.toList(first, additional));
    }
}
