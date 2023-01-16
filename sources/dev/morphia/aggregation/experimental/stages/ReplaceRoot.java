package dev.morphia.aggregation.experimental.stages;

import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.experimental.AggregationException;
import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.sofia.Sofia;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/ReplaceRoot.class */
public class ReplaceRoot extends Stage {
    private Expression value;
    private DocumentExpression document;

    protected ReplaceRoot(Expression expression) {
        this();
        this.value = expression;
    }

    protected ReplaceRoot() {
        super("$replaceRoot");
    }

    public static ReplaceRoot replaceRoot() {
        return new ReplaceRoot();
    }

    public static ReplaceRoot replaceRoot(Expression expression) {
        return new ReplaceRoot(expression);
    }

    @Deprecated(forRemoval = true)
    public static ReplaceRoot with() {
        return new ReplaceRoot();
    }

    @Deprecated(forRemoval = true)
    public static ReplaceRoot with(Expression expression) {
        return new ReplaceRoot(expression);
    }

    public ReplaceRoot field(String name, Expression expression) {
        if (this.value != null) {
            throw new AggregationException(Sofia.mixedModesNotAllowed(stageName(), new Locale[0]));
        }
        if (this.document == null) {
            this.document = Expressions.m1259of();
        }
        this.document.field(name, expression);
        return this;
    }

    @Nullable
    public DocumentExpression getDocument() {
        return this.document;
    }

    @Nullable
    public Expression getValue() {
        return this.value;
    }
}
