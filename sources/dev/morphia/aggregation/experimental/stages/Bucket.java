package dev.morphia.aggregation.experimental.stages;

import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Bucket.class */
public class Bucket extends Stage {
    private Expression groupBy;
    private List<Expression> boundaries;
    private Object defaultValue;
    private DocumentExpression output;

    protected Bucket() {
        super("$bucket");
    }

    public static Bucket bucket() {
        return new Bucket();
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static Bucket m1252of() {
        return new Bucket();
    }

    public Bucket boundaries(Expression... boundaries) {
        this.boundaries = Arrays.asList(boundaries);
        return this;
    }

    public Bucket defaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public List<Expression> getBoundaries() {
        return this.boundaries;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public Expression getGroupBy() {
        return this.groupBy;
    }

    public DocumentExpression getOutput() {
        return this.output;
    }

    public Bucket groupBy(Expression groupBy) {
        this.groupBy = groupBy;
        return this;
    }

    public Bucket outputField(String name, Expression value) {
        if (this.output == null) {
            this.output = Expressions.m1259of();
        }
        this.output.field(name, value);
        return this;
    }
}
