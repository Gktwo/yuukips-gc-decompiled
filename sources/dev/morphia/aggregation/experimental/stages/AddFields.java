package dev.morphia.aggregation.experimental.stages;

import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/AddFields.class */
public class AddFields extends Stage {
    private final DocumentExpression document = Expressions.m1259of();

    protected AddFields() {
        super("$addFields");
    }

    public static AddFields addFields() {
        return new AddFields();
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static AddFields m1254of() {
        return new AddFields();
    }

    public AddFields field(String name, Expression value) {
        this.document.field(name, value);
        return this;
    }

    public DocumentExpression getDocument() {
        return this.document;
    }
}
