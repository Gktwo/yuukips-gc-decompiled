package dev.morphia.aggregation.experimental.stages;

import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.query.experimental.filters.Filter;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/GraphLookup.class */
public class GraphLookup extends Stage {
    private String from;
    private Expression startWith;
    private String connectFromField;
    private String connectToField;

    /* renamed from: as */
    private String f469as;
    private Integer maxDepth;
    private String depthField;
    private Filter[] restriction;
    private Class fromType;

    public GraphLookup(String from) {
        this();
        this.from = from;
    }

    protected GraphLookup() {
        super("$graphLookup");
    }

    public GraphLookup(Class from) {
        this();
        this.fromType = from;
    }

    @Deprecated(forRemoval = true)
    public static GraphLookup from(String from) {
        return new GraphLookup(from);
    }

    @Deprecated(forRemoval = true)
    public static GraphLookup from(Class from) {
        return new GraphLookup(from);
    }

    public static GraphLookup graphLookup(String from) {
        return new GraphLookup(from);
    }

    public static GraphLookup graphLookup(Class<?> from) {
        return new GraphLookup(from);
    }

    /* renamed from: as */
    public GraphLookup m1247as(String as) {
        this.f469as = as;
        return this;
    }

    public GraphLookup connectFromField(String connectFromField) {
        this.connectFromField = connectFromField;
        return this;
    }

    public GraphLookup connectToField(String connectToField) {
        this.connectToField = connectToField;
        return this;
    }

    public GraphLookup depthField(String depthField) {
        this.depthField = depthField;
        return this;
    }

    @Nullable
    public String getAs() {
        return this.f469as;
    }

    @Nullable
    public String getConnectFromField() {
        return this.connectFromField;
    }

    @Nullable
    public String getConnectToField() {
        return this.connectToField;
    }

    @Nullable
    public String getDepthField() {
        return this.depthField;
    }

    @Nullable
    public String getFrom() {
        return this.from;
    }

    @Nullable
    public Class getFromType() {
        return this.fromType;
    }

    @Nullable
    public Integer getMaxDepth() {
        return this.maxDepth;
    }

    @Nullable
    public Filter[] getRestriction() {
        return this.restriction;
    }

    @Nullable
    public Expression getStartWith() {
        return this.startWith;
    }

    public GraphLookup maxDepth(Integer maxDepth) {
        this.maxDepth = maxDepth;
        return this;
    }

    public GraphLookup restrict(Filter... filters) {
        this.restriction = filters;
        return this;
    }

    public GraphLookup startWith(Expression startWith) {
        this.startWith = startWith;
        return this;
    }
}
