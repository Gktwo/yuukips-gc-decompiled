package dev.morphia.aggregation.experimental.stages;

import com.mongodb.client.model.BucketGranularity;
import dev.morphia.aggregation.experimental.expressions.Expressions;
import dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/AutoBucket.class */
public class AutoBucket extends Stage {
    private Expression groupBy;
    private Integer buckets;
    private DocumentExpression output;
    private BucketGranularity granularity;

    protected AutoBucket() {
        super("$bucketAuto");
    }

    public static AutoBucket autoBucket() {
        return new AutoBucket();
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static AutoBucket m1253of() {
        return new AutoBucket();
    }

    public AutoBucket buckets(Integer buckets) {
        this.buckets = buckets;
        return this;
    }

    public Integer getBuckets() {
        return this.buckets;
    }

    public BucketGranularity getGranularity() {
        return this.granularity;
    }

    public Expression getGroupBy() {
        return this.groupBy;
    }

    public DocumentExpression getOutput() {
        return this.output;
    }

    public AutoBucket granularity(BucketGranularity granularity) {
        this.granularity = granularity;
        return this;
    }

    public AutoBucket groupBy(Expression groupBy) {
        this.groupBy = groupBy;
        return this;
    }

    public AutoBucket outputField(String name, Expression value) {
        if (this.output == null) {
            this.output = Expressions.m1259of();
        }
        this.output.field(name, value);
        return this;
    }
}
