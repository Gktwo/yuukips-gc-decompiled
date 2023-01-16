package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/SystemVariables.class */
public final class SystemVariables {
    public static final Expression CLUSTER_TIME = Expressions.value("$$CLUSTER_TIME");
    public static final Expression CURRENT = Expressions.value("$$CURRENT");
    public static final Expression DESCEND = Expressions.value("$$DESCEND");
    public static final Expression KEEP = Expressions.value("$$KEEP");
    public static final Expression NOW = Expressions.value("$$NOW");
    public static final Expression PRUNE = Expressions.value("$$PRUNE");
    public static final Expression REMOVE = Expressions.value("$$REMOVE");
    public static final Expression ROOT = Expressions.value("$$ROOT");

    private SystemVariables() {
    }
}
