package dev.morphia.aggregation.experimental.stages;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Redact.class */
public class Redact extends Stage {
    private Expression expression;

    protected Redact() {
        super("$redact");
    }

    @Deprecated(forRemoval = true)
    /* renamed from: on */
    public static Redact m1232on(Expression expression) {
        Redact redact = new Redact();
        redact.expression = expression;
        return redact;
    }

    public static Redact redact(Expression expression) {
        Redact redact = new Redact();
        redact.expression = expression;
        return redact;
    }

    public Expression getExpression() {
        return this.expression;
    }
}
