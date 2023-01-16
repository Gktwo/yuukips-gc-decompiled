package dev.morphia.aggregation.experimental;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.stages.AddFields;
import dev.morphia.aggregation.experimental.stages.AutoBucket;
import dev.morphia.aggregation.experimental.stages.Bucket;
import dev.morphia.aggregation.experimental.stages.CollectionStats;
import dev.morphia.aggregation.experimental.stages.CurrentOp;
import dev.morphia.aggregation.experimental.stages.Facet;
import dev.morphia.aggregation.experimental.stages.GeoNear;
import dev.morphia.aggregation.experimental.stages.GraphLookup;
import dev.morphia.aggregation.experimental.stages.Group;
import dev.morphia.aggregation.experimental.stages.Lookup;
import dev.morphia.aggregation.experimental.stages.Merge;
import dev.morphia.aggregation.experimental.stages.Out;
import dev.morphia.aggregation.experimental.stages.Projection;
import dev.morphia.aggregation.experimental.stages.Redact;
import dev.morphia.aggregation.experimental.stages.ReplaceRoot;
import dev.morphia.aggregation.experimental.stages.ReplaceWith;
import dev.morphia.aggregation.experimental.stages.Sort;
import dev.morphia.aggregation.experimental.stages.Stage;
import dev.morphia.aggregation.experimental.stages.Unset;
import dev.morphia.aggregation.experimental.stages.Unwind;
import dev.morphia.query.experimental.filters.Filter;
import dev.morphia.query.internal.MorphiaCursor;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/Aggregation.class */
public interface Aggregation<T> {
    Aggregation<T> addFields(AddFields addFields);

    Aggregation<T> autoBucket(AutoBucket autoBucket);

    Aggregation<T> bucket(Bucket bucket);

    Aggregation<T> collStats(CollectionStats collectionStats);

    Aggregation<T> count(String str);

    Aggregation<T> currentOp(CurrentOp currentOp);

    <S> MorphiaCursor<S> execute(Class<S> cls);

    <S> MorphiaCursor<S> execute(Class<S> cls, AggregationOptions aggregationOptions);

    Aggregation<T> facet(Facet facet);

    Aggregation<T> geoNear(GeoNear geoNear);

    Aggregation<T> graphLookup(GraphLookup graphLookup);

    Aggregation<T> group(Group group);

    Aggregation<T> indexStats();

    Aggregation<T> limit(long j);

    Aggregation<T> lookup(Lookup lookup);

    Aggregation<T> match(Filter... filterArr);

    <M> void merge(Merge<M> merge);

    <M> void merge(Merge<M> merge, AggregationOptions aggregationOptions);

    <O> void out(Out<O> out);

    <O> void out(Out<O> out, AggregationOptions aggregationOptions);

    Aggregation<T> planCacheStats();

    Aggregation<T> project(Projection projection);

    Aggregation<T> redact(Redact redact);

    Aggregation<T> replaceRoot(ReplaceRoot replaceRoot);

    Aggregation<T> replaceWith(ReplaceWith replaceWith);

    Aggregation<T> sample(long j);

    Aggregation<T> skip(long j);

    Aggregation<T> sort(Sort sort);

    Aggregation<T> sortByCount(Expression expression);

    Aggregation<T> unionWith(Class<?> cls, Stage stage, Stage... stageArr);

    Aggregation<T> unionWith(String str, Stage stage, Stage... stageArr);

    Aggregation<T> unset(Unset unset);

    Aggregation<T> unwind(Unwind unwind);

    default Aggregation<T> set(AddFields fields) {
        return addFields(fields);
    }
}
