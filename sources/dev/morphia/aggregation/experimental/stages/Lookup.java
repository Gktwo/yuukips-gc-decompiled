package dev.morphia.aggregation.experimental.stages;

import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Lookup.class */
public class Lookup extends Stage {
    private String from;
    private Class<?> fromType;
    private String localField;
    private String foreignField;

    /* renamed from: as */
    private String f471as;
    private DocumentExpression variables;
    private List<Stage> pipeline;

    protected Lookup(Class<?> fromType) {
        super("$lookup");
        this.fromType = fromType;
    }

    protected Lookup(String from) {
        super("$lookup");
        this.from = from;
    }

    @Deprecated(forRemoval = true)
    public static Lookup from(Class<?> from) {
        return new Lookup(from);
    }

    @Deprecated(forRemoval = true)
    public static Lookup from(String from) {
        return new Lookup(from);
    }

    public static Lookup lookup(Class<?> from) {
        return new Lookup(from);
    }

    public static Lookup lookup(String from) {
        return new Lookup(from);
    }

    /* renamed from: as */
    public Lookup m1239as(String as) {
        this.f471as = as;
        return this;
    }

    public Lookup foreignField(String foreignField) {
        this.foreignField = foreignField;
        return this;
    }

    @Nullable
    public String getAs() {
        return this.f471as;
    }

    @Nullable
    public String getForeignField() {
        return this.foreignField;
    }

    @Nullable
    public String getFrom() {
        return this.from;
    }

    @Nullable
    public Class<?> getFromType() {
        return this.fromType;
    }

    @Nullable
    public String getLocalField() {
        return this.localField;
    }

    @Nullable
    public List<Stage> getPipeline() {
        return this.pipeline;
    }

    public DocumentExpression getVariables() {
        return this.variables;
    }

    public Lookup let(String name, Expression expression) {
        if (this.variables == null) {
            this.variables = Expressions.m1259of();
        }
        this.variables.field(name, expression);
        return this;
    }

    public Lookup localField(String localField) {
        this.localField = localField;
        return this;
    }

    public Lookup pipeline(Stage... stages) {
        this.pipeline = Arrays.asList(stages);
        return this;
    }
}
