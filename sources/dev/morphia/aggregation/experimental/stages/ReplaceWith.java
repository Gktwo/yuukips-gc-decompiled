package dev.morphia.aggregation.experimental.stages;

import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.experimental.AggregationException;
import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.sofia.Sofia;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/ReplaceWith.class */
public class ReplaceWith extends Stage {
    private Expression value;
    private DocumentExpression document;

    protected ReplaceWith(Expression expression) {
        this();
        this.value = expression;
    }

    protected ReplaceWith() {
        super("$replaceWith");
    }

    public static ReplaceWith replaceWith() {
        return new ReplaceWith();
    }

    public static ReplaceWith replaceWith(Expression expression) {
        return new ReplaceWith(expression);
    }

    @Deprecated(forRemoval = true)
    public static ReplaceWith with() {
        return new ReplaceWith();
    }

    @Deprecated(forRemoval = true)
    public static ReplaceWith with(Expression expression) {
        return new ReplaceWith(expression);
    }

    public ReplaceWith field(String name, Expression expression) {
        if (this.value != null) {
            throw new AggregationException(Sofia.mixedModesNotAllowed(stageName(), new Locale[0]));
        }
        if (this.document == null) {
            this.document = Expressions.m1259of();
        }
        this.document.field(name, expression);
        return this;
    }

    public DocumentExpression getDocument() {
        return this.document;
    }

    @Nullable
    public Expression getValue() {
        return this.value;
    }
}
