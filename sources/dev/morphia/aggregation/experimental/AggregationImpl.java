package dev.morphia.aggregation.experimental;

import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.aggregation.experimental.expressions.Expressions;
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
import dev.morphia.aggregation.experimental.stages.Stage;
import dev.morphia.aggregation.experimental.stages.UnionWith;
import dev.morphia.aggregation.experimental.stages.Unset;
import dev.morphia.aggregation.experimental.stages.Unwind;
import dev.morphia.mapping.codec.reader.DocumentReader;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import dev.morphia.query.experimental.filters.Filter;
import dev.morphia.query.internal.MorphiaCursor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/AggregationImpl.class */
public class AggregationImpl<T> implements Aggregation<T> {
    private final Datastore datastore;
    private final Class<?> source;
    private final MongoCollection<T> collection;
    private final List<Stage> stages;

    public AggregationImpl(Datastore datastore, MongoCollection<T> collection) {
        this.stages = new ArrayList();
        this.datastore = datastore;
        this.collection = collection;
        this.source = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Class<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public AggregationImpl(Datastore datastore, Class<T> source, MongoCollection<T> collection) {
        this.stages = new ArrayList();
        this.datastore = datastore;
        this.source = source;
        this.collection = collection;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> addFields(AddFields fields) {
        addStage(fields);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> autoBucket(AutoBucket bucket) {
        addStage(bucket);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> bucket(Bucket bucket) {
        addStage(bucket);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> collStats(CollectionStats stats) {
        addStage(stats);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> count(String name) {
        addStage(new Count(name));
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> currentOp(CurrentOp currentOp) {
        addStage(currentOp);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> facet(Facet facet) {
        addStage(facet);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public <R> MorphiaCursor<R> execute(Class<R> resultType) {
        MongoCursor mongoCursor;
        if (!this.datastore.getMapper().isMappable(resultType) || resultType.equals(this.collection.getDocumentClass())) {
            mongoCursor = this.collection.aggregate(getDocuments(), resultType).iterator();
        } else {
            mongoCursor = new MappingCursor(this.collection.withDocumentClass(Document.class).aggregate(getDocuments()).iterator(), this.datastore.getMapper().getCodecRegistry().get(resultType), this.datastore.getMapper().getEntityModel(this.collection.getDocumentClass()).getDiscriminatorKey());
        }
        return new MorphiaCursor<>(mongoCursor);
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public <R> MorphiaCursor<R> execute(Class<R> resultType, AggregationOptions options) {
        return new MorphiaCursor<>(options.apply(getDocuments(), this.collection, resultType).iterator());
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> geoNear(GeoNear near) {
        addStage(near);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> graphLookup(GraphLookup lookup) {
        addStage(lookup);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> group(Group group) {
        addStage(group);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> indexStats() {
        addStage(IndexStats.indexStats());
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> limit(long limit) {
        addStage(Limit.limit(limit));
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> lookup(Lookup lookup) {
        addStage(lookup);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> match(Filter... filters) {
        if (this.stages.isEmpty()) {
            Arrays.stream(filters).filter(f -> {
                return f.getName().equals("$eq");
            }).forEach(f -> {
                f.entityType(this.source);
            });
        }
        addStage(Match.match(filters));
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public <M> void merge(Merge<M> merge) {
        addStage(merge);
        this.collection.aggregate(getDocuments()).toCollection();
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public <M> void merge(Merge<M> merge, AggregationOptions options) {
        addStage(merge);
        Class<M> type = merge.getType();
        options.apply(getDocuments(), this.collection, type != null ? type : Document.class).toCollection();
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public <O> void out(Out<O> out) {
        addStage(out);
        this.collection.aggregate(getDocuments()).toCollection();
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public <O> void out(Out<O> out, AggregationOptions options) {
        addStage(out);
        Class<?> type = out.getType();
        options.apply(getDocuments(), this.collection, type != null ? type : Document.class).toCollection();
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> planCacheStats() {
        addStage(PlanCacheStats.planCacheStats());
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> project(Projection projection) {
        addStage(projection);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> redact(Redact redact) {
        addStage(redact);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> replaceRoot(ReplaceRoot root) {
        addStage(root);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> replaceWith(ReplaceWith with) {
        addStage(with);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> sample(long sample) {
        addStage(Sample.sample(sample));
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> skip(long skip) {
        addStage(Skip.skip(skip));
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> sort(Sort sort) {
        addStage(sort);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> sortByCount(Expression sort) {
        addStage(SortByCount.sortByCount(sort));
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> unionWith(Class<?> type, Stage first, Stage... others) {
        addStage(new UnionWith(type, Expressions.toList(first, others)));
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> unionWith(String collection, Stage first, Stage... others) {
        addStage(new UnionWith(collection, Expressions.toList(first, others)));
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> unset(Unset unset) {
        addStage(unset);
        return this;
    }

    @Override // dev.morphia.aggregation.experimental.Aggregation
    public Aggregation<T> unwind(Unwind unwind) {
        addStage(unwind);
        return this;
    }

    private void addStage(Stage stage) {
        stage.aggregation(this);
        this.stages.add(stage);
    }

    private List<Document> getDocuments() {
        return (List) this.stages.stream().map(s -> {
            Codec codec = this.datastore.getMapper().getCodecRegistry().get(s.getClass());
            DocumentWriter writer = new DocumentWriter(this.datastore.getMapper());
            codec.encode(writer, s, EncoderContext.builder().build());
            return writer.getDocument();
        }).collect(Collectors.toList());
    }

    /* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/AggregationImpl$MappingCursor.class */
    private static class MappingCursor<R> implements MongoCursor<R> {
        private final MongoCursor<Document> results;
        private final Codec<R> codec;
        private final String discriminator;

        MappingCursor(MongoCursor<Document> results, Codec<R> codec, String discriminator) {
            this.results = results;
            this.codec = codec;
            this.discriminator = discriminator;
        }

        @Override // com.mongodb.client.MongoCursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.results.close();
        }

        @Override // com.mongodb.client.MongoCursor, java.util.Iterator
        public boolean hasNext() {
            return this.results.hasNext();
        }

        @Override // com.mongodb.client.MongoCursor, java.util.Iterator
        public R next() {
            return map(this.results.next());
        }

        @Override // com.mongodb.client.MongoCursor
        @Nullable
        public R tryNext() {
            if (hasNext()) {
                return next();
            }
            return null;
        }

        @Override // com.mongodb.client.MongoCursor
        @Nullable
        public ServerCursor getServerCursor() {
            return this.results.getServerCursor();
        }

        @Override // com.mongodb.client.MongoCursor
        public ServerAddress getServerAddress() {
            return this.results.getServerAddress();
        }

        private R map(Document next) {
            next.remove(this.discriminator);
            return this.codec.decode(new DocumentReader(next), DecoderContext.builder().build());
        }
    }
}
