package dev.morphia.aggregation.experimental.stages;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/SortByCount.class */
public class SortByCount extends Stage {
    private final Expression expression;

    protected SortByCount(Expression expression) {
        super("$sortByCount");
        this.expression = expression;
    }

    @Deprecated(forRemoval = true)
    /* renamed from: on */
    public static SortByCount m1228on(Expression expression) {
        return new SortByCount(expression);
    }

    public static SortByCount sortByCount(Expression expression) {
        return new SortByCount(expression);
    }

    public Expression getExpression() {
        return this.expression;
    }
}
