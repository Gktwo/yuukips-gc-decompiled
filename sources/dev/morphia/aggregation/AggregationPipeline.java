package dev.morphia.aggregation;

import com.mongodb.AggregationOptions;
import com.mongodb.ReadPreference;
import com.mongodb.client.model.UnwindOptions;
import dev.morphia.query.BucketAutoOptions;
import dev.morphia.query.BucketOptions;
import dev.morphia.query.Query;
import dev.morphia.query.Sort;
import java.util.Iterator;
import java.util.List;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/aggregation/AggregationPipeline.class */
public interface AggregationPipeline {
    <U> Iterator<U> aggregate(Class<U> cls);

    <U> Iterator<U> aggregate(Class<U> cls, AggregationOptions aggregationOptions);

    <U> Iterator<U> aggregate(Class<U> cls, AggregationOptions aggregationOptions, ReadPreference readPreference);

    <U> Iterator<U> aggregate(String str, Class<U> cls, AggregationOptions aggregationOptions, ReadPreference readPreference);

    AggregationPipeline bucket(String str, List<?> list);

    AggregationPipeline bucket(String str, List<?> list, BucketOptions bucketOptions);

    AggregationPipeline bucketAuto(String str, int i);

    AggregationPipeline bucketAuto(String str, int i, BucketAutoOptions bucketAutoOptions);

    AggregationPipeline geoNear(GeoNear geoNear);

    AggregationPipeline group(Group... groupArr);

    AggregationPipeline group(String str, Group... groupArr);

    AggregationPipeline group(List<Group> list, Group... groupArr);

    AggregationPipeline limit(int i);

    AggregationPipeline lookup(String str, String str2, String str3, String str4);

    AggregationPipeline match(Query query);

    <U> Iterator<U> out(Class<U> cls);

    <U> Iterator<U> out(Class<U> cls, AggregationOptions aggregationOptions);

    <U> Iterator<U> out(String str, Class<U> cls);

    <U> Iterator<U> out(String str, Class<U> cls, AggregationOptions aggregationOptions);

    AggregationPipeline project(Projection... projectionArr);

    AggregationPipeline sample(int i);

    AggregationPipeline skip(int i);

    AggregationPipeline sort(Sort... sortArr);

    AggregationPipeline sortByCount(String str);

    AggregationPipeline unwind(String str, UnwindOptions unwindOptions);

    AggregationPipeline unwind(String str);
}
