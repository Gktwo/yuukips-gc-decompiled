package dev.morphia.aggregation.experimental.expressions;

import com.mongodb.QueryOperators;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/ComparisonExpressions.class */
public final class ComparisonExpressions {
    private ComparisonExpressions() {
    }

    public static Expression cmp(Expression first, Expression second) {
        return new Expression("$cmp", List.of(first, second));
    }

    /* renamed from: eq */
    public static Expression m1263eq(Expression first, Expression second) {
        return new Expression("$eq", List.of(first, second));
    }

    /* renamed from: gt */
    public static Expression m1262gt(Expression first, Expression second) {
        return new Expression(QueryOperators.f429GT, List.of(first, second));
    }

    public static Expression gte(Expression first, Expression second) {
        return new Expression(QueryOperators.GTE, List.of(first, second));
    }

    /* renamed from: lt */
    public static Expression m1261lt(Expression first, Expression second) {
        return new Expression(QueryOperators.f430LT, List.of(first, second));
    }

    public static Expression lte(Expression first, Expression second) {
        return new Expression(QueryOperators.LTE, List.of(first, second));
    }

    /* renamed from: ne */
    public static Expression m1260ne(Expression first, Expression second) {
        return new Expression(QueryOperators.f431NE, List.of(first, second));
    }
}
