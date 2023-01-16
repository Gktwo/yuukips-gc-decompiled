package dev.morphia.aggregation.experimental.stages;

import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Unwind.class */
public class Unwind extends Stage {
    private Expression path;
    private String includeArrayIndex;
    private Boolean preserveNullAndEmptyArrays;

    protected Unwind() {
        super("$unwind");
    }

    @Deprecated(forRemoval = true)
    /* renamed from: on */
    public static Unwind m1227on(String name) {
        return new Unwind().path(name);
    }

    public static Unwind unwind(String name) {
        return new Unwind().path(name);
    }

    public String getIncludeArrayIndex() {
        return this.includeArrayIndex;
    }

    public Expression getPath() {
        return this.path;
    }

    public Boolean getPreserveNullAndEmptyArrays() {
        return this.preserveNullAndEmptyArrays;
    }

    public Unwind includeArrayIndex(String name) {
        this.includeArrayIndex = name;
        return this;
    }

    public boolean optionsPresent() {
        return (this.includeArrayIndex == null && this.preserveNullAndEmptyArrays == null) ? false : true;
    }

    public Unwind preserveNullAndEmptyArrays(Boolean preserveNullAndEmptyArrays) {
        this.preserveNullAndEmptyArrays = preserveNullAndEmptyArrays;
        return this;
    }

    private Unwind path(String path) {
        this.path = Expressions.field(path);
        return this;
    }
}
