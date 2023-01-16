package dev.morphia.aggregation.experimental.codecs;

import dev.morphia.aggregation.experimental.codecs.stages.AddFieldsCodec;
import dev.morphia.aggregation.experimental.codecs.stages.AutoBucketCodec;
import dev.morphia.aggregation.experimental.codecs.stages.BucketCodec;
import dev.morphia.aggregation.experimental.codecs.stages.CollectionStatsCodec;
import dev.morphia.aggregation.experimental.codecs.stages.CountCodec;
import dev.morphia.aggregation.experimental.codecs.stages.CurrentOpCodec;
import dev.morphia.aggregation.experimental.codecs.stages.FacetCodec;
import dev.morphia.aggregation.experimental.codecs.stages.GeoNearCodec;
import dev.morphia.aggregation.experimental.codecs.stages.GraphLookupCodec;
import dev.morphia.aggregation.experimental.codecs.stages.GroupCodec;
import dev.morphia.aggregation.experimental.codecs.stages.IndexStatsCodec;
import dev.morphia.aggregation.experimental.codecs.stages.LimitCodec;
import dev.morphia.aggregation.experimental.codecs.stages.LookupCodec;
import dev.morphia.aggregation.experimental.codecs.stages.MatchCodec;
import dev.morphia.aggregation.experimental.codecs.stages.MergeCodec;
import dev.morphia.aggregation.experimental.codecs.stages.OutCodec;
import dev.morphia.aggregation.experimental.codecs.stages.PlanCacheStatsCodec;
import dev.morphia.aggregation.experimental.codecs.stages.ProjectionCodec;
import dev.morphia.aggregation.experimental.codecs.stages.RedactCodec;
import dev.morphia.aggregation.experimental.codecs.stages.ReplaceRootCodec;
import dev.morphia.aggregation.experimental.codecs.stages.ReplaceWithCodec;
import dev.morphia.aggregation.experimental.codecs.stages.SampleCodec;
import dev.morphia.aggregation.experimental.codecs.stages.SkipCodec;
import dev.morphia.aggregation.experimental.codecs.stages.SortByCountCodec;
import dev.morphia.aggregation.experimental.codecs.stages.SortCodec;
import dev.morphia.aggregation.experimental.codecs.stages.StageCodec;
import dev.morphia.aggregation.experimental.codecs.stages.UnionWithCodec;
import dev.morphia.aggregation.experimental.codecs.stages.UnsetCodec;
import dev.morphia.aggregation.experimental.codecs.stages.UnwindCodec;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.stages.AddFields;
import dev.morphia.aggregation.experimental.stages.AutoBucket;
import dev.morphia.aggregation.experimental.stages.Bucket;
import dev.morphia.aggregation.experimental.stages.CollectionStats;
import dev.morphia.aggregation.experimental.stages.Count;
import dev.morphia.aggregation.experimental.stages.CurrentOp;
import dev.morphia.aggregation.experimental.stages.Facet;
import dev.morphia.aggregation.experimental.stages.GeoNear;
import dev.morphia.aggregation.experimental.stages.GraphLookup;
import dev.morphia.aggregation.experimental.stages.Group;
import dev.morphia.aggregation.experimental.stages.IndexStats;
import dev.morphia.aggregation.experimental.stages.Limit;
import dev.morphia.aggregation.experimental.stages.Lookup;
import dev.morphia.aggregation.experimental.stages.Match;
import dev.morphia.aggregation.experimental.stages.Merge;
import dev.morphia.aggregation.experimental.stages.Out;
import dev.morphia.aggregation.experimental.stages.PlanCacheStats;
import dev.morphia.aggregation.experimental.stages.Projection;
import dev.morphia.aggregation.experimental.stages.Redact;
import dev.morphia.aggregation.experimental.stages.ReplaceRoot;
import dev.morphia.aggregation.experimental.stages.ReplaceWith;
import dev.morphia.aggregation.experimental.stages.Sample;
import dev.morphia.aggregation.experimental.stages.Skip;
import dev.morphia.aggregation.experimental.stages.Sort;
import dev.morphia.aggregation.experimental.stages.SortByCount;
import dev.morphia.aggregation.experimental.stages.UnionWith;
import dev.morphia.aggregation.experimental.stages.Unset;
import dev.morphia.aggregation.experimental.stages.Unwind;
import dev.morphia.mapping.Mapper;
import java.util.HashMap;
import java.util.Map;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/AggregationCodecProvider.class */
public class AggregationCodecProvider implements CodecProvider {
    private final Codec expressionCodec;
    private final Mapper mapper;
    private Map<Class, StageCodec> codecs;

    public AggregationCodecProvider(Mapper mapper) {
        this.mapper = mapper;
        this.expressionCodec = new ExpressionCodec(this.mapper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        Codec<T> codec = getCodecs().get(clazz);
        if (codec == null && Expression.class.isAssignableFrom(clazz)) {
            codec = this.expressionCodec;
        }
        return codec;
    }

    private Map<Class, StageCodec> getCodecs() {
        if (this.codecs == null) {
            this.codecs = new HashMap();
            this.codecs.put(AddFields.class, new AddFieldsCodec(this.mapper));
            this.codecs.put(AutoBucket.class, new AutoBucketCodec(this.mapper));
            this.codecs.put(Bucket.class, new BucketCodec(this.mapper));
            this.codecs.put(CollectionStats.class, new CollectionStatsCodec(this.mapper));
            this.codecs.put(Count.class, new CountCodec(this.mapper));
            this.codecs.put(CurrentOp.class, new CurrentOpCodec(this.mapper));
            this.codecs.put(Facet.class, new FacetCodec(this.mapper));
            this.codecs.put(GeoNear.class, new GeoNearCodec(this.mapper));
            this.codecs.put(GraphLookup.class, new GraphLookupCodec(this.mapper));
            this.codecs.put(Group.class, new GroupCodec(this.mapper));
            this.codecs.put(IndexStats.class, new IndexStatsCodec(this.mapper));
            this.codecs.put(Merge.class, new MergeCodec(this.mapper));
            this.codecs.put(PlanCacheStats.class, new PlanCacheStatsCodec(this.mapper));
            this.codecs.put(Limit.class, new LimitCodec(this.mapper));
            this.codecs.put(Lookup.class, new LookupCodec(this.mapper));
            this.codecs.put(Match.class, new MatchCodec(this.mapper));
            this.codecs.put(Out.class, new OutCodec(this.mapper));
            this.codecs.put(Projection.class, new ProjectionCodec(this.mapper));
            this.codecs.put(Redact.class, new RedactCodec(this.mapper));
            this.codecs.put(ReplaceRoot.class, new ReplaceRootCodec(this.mapper));
            this.codecs.put(ReplaceWith.class, new ReplaceWithCodec(this.mapper));
            this.codecs.put(Sample.class, new SampleCodec(this.mapper));
            this.codecs.put(Skip.class, new SkipCodec(this.mapper));
            this.codecs.put(Sort.class, new SortCodec(this.mapper));
            this.codecs.put(SortByCount.class, new SortByCountCodec(this.mapper));
            this.codecs.put(UnionWith.class, new UnionWithCodec(this.mapper));
            this.codecs.put(Unset.class, new UnsetCodec(this.mapper));
            this.codecs.put(Unwind.class, new UnwindCodec(this.mapper));
        }
        return this.codecs;
    }
}
