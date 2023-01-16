package com.mongodb.client.model;

import com.mongodb.DBCollection;
import com.mongodb.MongoNamespace;
import com.mongodb.lang.Nullable;
import java.util.Arrays;
import java.util.List;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWriter;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.assertions.Assertions;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.jline.console.Printer;
import p001ch.qos.logback.classic.joran.action.InsertFromJNDIAction;
import p001ch.qos.logback.core.pattern.parser.Parser;

/* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates.class */
public final class Aggregates {
    public static Bson addFields(Field<?>... fields) {
        return addFields(Arrays.asList(fields));
    }

    public static Bson addFields(List<Field<?>> fields) {
        return new AddFieldsStage(fields);
    }

    public static <TExpression, Boundary> Bson bucket(TExpression groupBy, List<Boundary> boundaries) {
        return bucket(groupBy, boundaries, new BucketOptions());
    }

    public static <TExpression, TBoundary> Bson bucket(TExpression groupBy, List<TBoundary> boundaries, BucketOptions options) {
        return new BucketStage(groupBy, boundaries, options);
    }

    public static <TExpression> Bson bucketAuto(TExpression groupBy, int buckets) {
        return bucketAuto(groupBy, buckets, new BucketAutoOptions());
    }

    public static <TExpression> Bson bucketAuto(TExpression groupBy, int buckets, BucketAutoOptions options) {
        return new BucketAutoStage(groupBy, buckets, options);
    }

    public static Bson count() {
        return count("count");
    }

    public static Bson count(String field) {
        return new BsonDocument("$count", new BsonString(field));
    }

    public static Bson match(Bson filter) {
        return new SimplePipelineStage("$match", filter);
    }

    public static Bson project(Bson projection) {
        return new SimplePipelineStage("$project", projection);
    }

    public static Bson sort(Bson sort) {
        return new SimplePipelineStage("$sort", sort);
    }

    public static <TExpression> Bson sortByCount(TExpression filter) {
        return new SortByCountStage(filter);
    }

    public static Bson skip(int skip) {
        return new BsonDocument("$skip", new BsonInt32(skip));
    }

    public static Bson limit(int limit) {
        return new BsonDocument("$limit", new BsonInt32(limit));
    }

    public static Bson lookup(String from, String localField, String foreignField, String as) {
        return new BsonDocument("$lookup", new BsonDocument("from", new BsonString(from)).append("localField", new BsonString(localField)).append("foreignField", new BsonString(foreignField)).append(InsertFromJNDIAction.AS_ATTR, new BsonString(as)));
    }

    public static Bson lookup(String from, List<? extends Bson> pipeline, String as) {
        return lookup(from, (List) null, pipeline, as);
    }

    public static <TExpression> Bson lookup(String from, @Nullable List<Variable<TExpression>> let, List<? extends Bson> pipeline, String as) {
        return new LookupStage(from, let, pipeline, as);
    }

    public static Bson facet(List<Facet> facets) {
        return new FacetStage(facets);
    }

    public static Bson facet(Facet... facets) {
        return new FacetStage(Arrays.asList(facets));
    }

    public static <TExpression> Bson graphLookup(String from, TExpression startWith, String connectFromField, String connectToField, String as) {
        return graphLookup(from, startWith, connectFromField, connectToField, as, new GraphLookupOptions());
    }

    public static <TExpression> Bson graphLookup(String from, TExpression startWith, String connectFromField, String connectToField, String as, GraphLookupOptions options) {
        Assertions.notNull("options", options);
        return new GraphLookupStage(from, startWith, connectFromField, connectToField, as, options);
    }

    public static <TExpression> Bson group(@Nullable TExpression id, BsonField... fieldAccumulators) {
        return group(id, Arrays.asList(fieldAccumulators));
    }

    public static <TExpression> Bson group(@Nullable TExpression id, List<BsonField> fieldAccumulators) {
        return new GroupStage(id, fieldAccumulators);
    }

    public static Bson unionWith(String collection, List<? extends Bson> pipeline) {
        return new UnionWithStage(collection, pipeline);
    }

    public static Bson unwind(String fieldName) {
        return new BsonDocument("$unwind", new BsonString(fieldName));
    }

    public static Bson unwind(String fieldName, UnwindOptions unwindOptions) {
        Assertions.notNull("unwindOptions", unwindOptions);
        BsonDocument options = new BsonDocument("path", new BsonString(fieldName));
        Boolean preserveNullAndEmptyArrays = unwindOptions.isPreserveNullAndEmptyArrays();
        if (preserveNullAndEmptyArrays != null) {
            options.append("preserveNullAndEmptyArrays", BsonBoolean.valueOf(preserveNullAndEmptyArrays.booleanValue()));
        }
        String includeArrayIndex = unwindOptions.getIncludeArrayIndex();
        if (includeArrayIndex != null) {
            options.append("includeArrayIndex", new BsonString(includeArrayIndex));
        }
        return new BsonDocument("$unwind", options);
    }

    public static Bson out(String collectionName) {
        return new BsonDocument("$out", new BsonString(collectionName));
    }

    public static Bson out(String databaseName, String collectionName) {
        return new BsonDocument("$out", new BsonDocument("db", new BsonString(databaseName)).append("coll", new BsonString(collectionName)));
    }

    public static Bson out(Bson destination) {
        return new SimplePipelineStage("$out", destination);
    }

    public static Bson merge(String collectionName) {
        return merge(collectionName, new MergeOptions());
    }

    public static Bson merge(MongoNamespace namespace) {
        return merge(namespace, new MergeOptions());
    }

    public static Bson merge(String collectionName, MergeOptions options) {
        return new MergeStage(new BsonString(collectionName), options);
    }

    public static Bson merge(MongoNamespace namespace, MergeOptions options) {
        return new MergeStage(new BsonDocument("db", new BsonString(namespace.getDatabaseName())).append("coll", new BsonString(namespace.getCollectionName())), options);
    }

    public static <TExpression> Bson replaceRoot(TExpression value) {
        return new ReplaceStage(value);
    }

    public static <TExpression> Bson replaceWith(TExpression value) {
        return new ReplaceStage(value, true);
    }

    public static Bson sample(int size) {
        return new BsonDocument("$sample", new BsonDocument("size", new BsonInt32(size)));
    }

    static void writeBucketOutput(CodecRegistry codecRegistry, BsonDocumentWriter writer, @Nullable List<BsonField> output) {
        if (output != null) {
            writer.writeName("output");
            writer.writeStartDocument();
            for (BsonField field : output) {
                writer.writeName(field.getName());
                BuildersHelper.encodeValue(writer, field.getValue(), codecRegistry);
            }
            writer.writeEndDocument();
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$SimplePipelineStage.class */
    private static class SimplePipelineStage implements Bson {
        private final String name;
        private final Bson value;

        SimplePipelineStage(String name, Bson value) {
            this.name = name;
            this.value = value;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            return new BsonDocument(this.name, this.value.toBsonDocument(documentClass, codecRegistry));
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            SimplePipelineStage that = (SimplePipelineStage) o;
            if (this.name != null) {
                if (!this.name.equals(that.name)) {
                    return false;
                }
            } else if (that.name != null) {
                return false;
            }
            return this.value != null ? this.value.equals(that.value) : that.value == null;
        }

        public int hashCode() {
            return (31 * (this.name != null ? this.name.hashCode() : 0)) + (this.value != null ? this.value.hashCode() : 0);
        }

        public String toString() {
            return "Stage{name='" + this.name + "', value=" + this.value + '}';
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$BucketStage.class */
    public static final class BucketStage<TExpression, TBoundary> implements Bson {
        private final TExpression groupBy;
        private final List<TBoundary> boundaries;
        private final BucketOptions options;

        BucketStage(TExpression groupBy, List<TBoundary> boundaries, BucketOptions options) {
            Assertions.notNull("options", options);
            this.groupBy = groupBy;
            this.boundaries = boundaries;
            this.options = options;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeStartDocument("$bucket");
            writer.writeName("groupBy");
            BuildersHelper.encodeValue(writer, this.groupBy, codecRegistry);
            writer.writeStartArray("boundaries");
            for (TBoundary boundary : this.boundaries) {
                BuildersHelper.encodeValue(writer, boundary, codecRegistry);
            }
            writer.writeEndArray();
            Object defaultBucket = this.options.getDefaultBucket();
            if (defaultBucket != null) {
                writer.writeName("default");
                BuildersHelper.encodeValue(writer, defaultBucket, codecRegistry);
            }
            Aggregates.writeBucketOutput(codecRegistry, writer, this.options.getOutput());
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            BucketStage<?, ?> that = (BucketStage) o;
            if (this.groupBy != null) {
                if (!this.groupBy.equals(that.groupBy)) {
                    return false;
                }
            } else if (that.groupBy != null) {
                return false;
            }
            if (this.boundaries != null) {
                if (!this.boundaries.equals(that.boundaries)) {
                    return false;
                }
            } else if (that.boundaries != null) {
                return false;
            }
            return this.options.equals(that.options);
        }

        public int hashCode() {
            return (31 * ((31 * (this.groupBy != null ? this.groupBy.hashCode() : 0)) + (this.boundaries != null ? this.boundaries.hashCode() : 0))) + this.options.hashCode();
        }

        public String toString() {
            return "Stage{name='$bucket', boundaries=" + this.boundaries + ", groupBy=" + this.groupBy + ", options=" + this.options + '}';
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$BucketAutoStage.class */
    public static final class BucketAutoStage<TExpression> implements Bson {
        private final TExpression groupBy;
        private final int buckets;
        private final BucketAutoOptions options;

        BucketAutoStage(TExpression groupBy, int buckets, BucketAutoOptions options) {
            Assertions.notNull("options", options);
            this.groupBy = groupBy;
            this.buckets = buckets;
            this.options = options;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeStartDocument("$bucketAuto");
            writer.writeName("groupBy");
            BuildersHelper.encodeValue(writer, this.groupBy, codecRegistry);
            writer.writeInt32("buckets", this.buckets);
            Aggregates.writeBucketOutput(codecRegistry, writer, this.options.getOutput());
            BucketGranularity granularity = this.options.getGranularity();
            if (granularity != null) {
                writer.writeString("granularity", granularity.getValue());
            }
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            BucketAutoStage<?> that = (BucketAutoStage) o;
            if (this.buckets != that.buckets) {
                return false;
            }
            if (this.groupBy != null) {
                if (!this.groupBy.equals(that.groupBy)) {
                    return false;
                }
            } else if (that.groupBy != null) {
                return false;
            }
            return this.options.equals(that.options);
        }

        public int hashCode() {
            return (31 * ((31 * (this.groupBy != null ? this.groupBy.hashCode() : 0)) + this.buckets)) + this.options.hashCode();
        }

        public String toString() {
            return "Stage{name='$bucketAuto', buckets=" + this.buckets + ", groupBy=" + this.groupBy + ", options=" + this.options + '}';
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$LookupStage.class */
    public static final class LookupStage<TExpression> implements Bson {
        private final String from;
        private final List<Variable<TExpression>> let;
        private final List<? extends Bson> pipeline;

        /* renamed from: as */
        private final String f445as;

        private LookupStage(String from, @Nullable List<Variable<TExpression>> let, List<? extends Bson> pipeline, String as) {
            this.from = from;
            this.let = let;
            this.pipeline = pipeline;
            this.f445as = as;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeStartDocument("$lookup");
            writer.writeString("from", this.from);
            if (this.let != null) {
                writer.writeStartDocument("let");
                for (Variable<TExpression> variable : this.let) {
                    writer.writeName(variable.getName());
                    BuildersHelper.encodeValue(writer, variable.getValue(), codecRegistry);
                }
                writer.writeEndDocument();
            }
            writer.writeName("pipeline");
            writer.writeStartArray();
            for (Bson stage : this.pipeline) {
                BuildersHelper.encodeValue(writer, stage, codecRegistry);
            }
            writer.writeEndArray();
            writer.writeString(InsertFromJNDIAction.AS_ATTR, this.f445as);
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            LookupStage<?> that = (LookupStage) o;
            if (this.from != null) {
                if (!this.from.equals(that.from)) {
                    return false;
                }
            } else if (that.from != null) {
                return false;
            }
            if (this.let != null) {
                if (!this.let.equals(that.let)) {
                    return false;
                }
            } else if (that.let != null) {
                return false;
            }
            if (this.pipeline != null) {
                if (!this.pipeline.equals(that.pipeline)) {
                    return false;
                }
            } else if (that.pipeline != null) {
                return false;
            }
            return this.f445as != null ? this.f445as.equals(that.f445as) : that.f445as == null;
        }

        public int hashCode() {
            return (31 * ((31 * ((31 * (this.from != null ? this.from.hashCode() : 0)) + (this.let != null ? this.let.hashCode() : 0))) + (this.pipeline != null ? this.pipeline.hashCode() : 0))) + (this.f445as != null ? this.f445as.hashCode() : 0);
        }

        public String toString() {
            return "Stage{name='$lookup', from='" + this.from + "', let=" + this.let + ", pipeline=" + this.pipeline + ", as='" + this.f445as + "'}";
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$GraphLookupStage.class */
    public static final class GraphLookupStage<TExpression> implements Bson {
        private final String from;
        private final TExpression startWith;
        private final String connectFromField;
        private final String connectToField;

        /* renamed from: as */
        private final String f443as;
        private final GraphLookupOptions options;

        private GraphLookupStage(String from, TExpression startWith, String connectFromField, String connectToField, String as, GraphLookupOptions options) {
            this.from = from;
            this.startWith = startWith;
            this.connectFromField = connectFromField;
            this.connectToField = connectToField;
            this.f443as = as;
            this.options = options;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeStartDocument("$graphLookup");
            writer.writeString("from", this.from);
            writer.writeName("startWith");
            BuildersHelper.encodeValue(writer, this.startWith, codecRegistry);
            writer.writeString("connectFromField", this.connectFromField);
            writer.writeString("connectToField", this.connectToField);
            writer.writeString(InsertFromJNDIAction.AS_ATTR, this.f443as);
            Integer maxDepth = this.options.getMaxDepth();
            if (maxDepth != null) {
                writer.writeInt32(Printer.MAX_DEPTH, maxDepth.intValue());
            }
            String depthField = this.options.getDepthField();
            if (depthField != null) {
                writer.writeString("depthField", depthField);
            }
            Bson restrictSearchWithMatch = this.options.getRestrictSearchWithMatch();
            if (restrictSearchWithMatch != null) {
                writer.writeName("restrictSearchWithMatch");
                BuildersHelper.encodeValue(writer, restrictSearchWithMatch, codecRegistry);
            }
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            GraphLookupStage<?> that = (GraphLookupStage) o;
            if (this.from != null) {
                if (!this.from.equals(that.from)) {
                    return false;
                }
            } else if (that.from != null) {
                return false;
            }
            if (this.startWith != null) {
                if (!this.startWith.equals(that.startWith)) {
                    return false;
                }
            } else if (that.startWith != null) {
                return false;
            }
            if (this.connectFromField != null) {
                if (!this.connectFromField.equals(that.connectFromField)) {
                    return false;
                }
            } else if (that.connectFromField != null) {
                return false;
            }
            if (this.connectToField != null) {
                if (!this.connectToField.equals(that.connectToField)) {
                    return false;
                }
            } else if (that.connectToField != null) {
                return false;
            }
            if (this.f443as != null) {
                if (!this.f443as.equals(that.f443as)) {
                    return false;
                }
            } else if (that.f443as != null) {
                return false;
            }
            return this.options != null ? this.options.equals(that.options) : that.options == null;
        }

        public int hashCode() {
            return (31 * ((31 * ((31 * ((31 * ((31 * (this.from != null ? this.from.hashCode() : 0)) + (this.startWith != null ? this.startWith.hashCode() : 0))) + (this.connectFromField != null ? this.connectFromField.hashCode() : 0))) + (this.connectToField != null ? this.connectToField.hashCode() : 0))) + (this.f443as != null ? this.f443as.hashCode() : 0))) + (this.options != null ? this.options.hashCode() : 0);
        }

        public String toString() {
            return "Stage{name='$graphLookup', as='" + this.f443as + "', connectFromField='" + this.connectFromField + "', connectToField='" + this.connectToField + "', from='" + this.from + "', options=" + this.options + ", startWith=" + this.startWith + '}';
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$GroupStage.class */
    public static class GroupStage<TExpression> implements Bson {

        /* renamed from: id */
        private final TExpression f444id;
        private final List<BsonField> fieldAccumulators;

        GroupStage(TExpression id, List<BsonField> fieldAccumulators) {
            this.f444id = id;
            this.fieldAccumulators = fieldAccumulators;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeStartDocument("$group");
            writer.writeName(DBCollection.ID_FIELD_NAME);
            BuildersHelper.encodeValue(writer, this.f444id, codecRegistry);
            for (BsonField fieldAccumulator : this.fieldAccumulators) {
                writer.writeName(fieldAccumulator.getName());
                BuildersHelper.encodeValue(writer, fieldAccumulator.getValue(), codecRegistry);
            }
            writer.writeEndDocument();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            GroupStage<?> that = (GroupStage) o;
            if (this.f444id != null) {
                if (!this.f444id.equals(that.f444id)) {
                    return false;
                }
            } else if (that.f444id != null) {
                return false;
            }
            return this.fieldAccumulators != null ? this.fieldAccumulators.equals(that.fieldAccumulators) : that.fieldAccumulators == null;
        }

        public int hashCode() {
            return (31 * (this.f444id != null ? this.f444id.hashCode() : 0)) + (this.fieldAccumulators != null ? this.fieldAccumulators.hashCode() : 0);
        }

        public String toString() {
            return "Stage{name='$group', id=" + this.f444id + ", fieldAccumulators=" + this.fieldAccumulators + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$SortByCountStage.class */
    private static class SortByCountStage<TExpression> implements Bson {
        private final TExpression filter;

        SortByCountStage(TExpression filter) {
            this.filter = filter;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName("$sortByCount");
            BuildersHelper.encodeValue(writer, this.filter, codecRegistry);
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            SortByCountStage<?> that = (SortByCountStage) o;
            return this.filter != null ? this.filter.equals(that.filter) : that.filter == null;
        }

        public int hashCode() {
            if (this.filter != null) {
                return this.filter.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Stage{name='$sortByCount', id=" + this.filter + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$FacetStage.class */
    private static class FacetStage implements Bson {
        private final List<Facet> facets;

        FacetStage(List<Facet> facets) {
            this.facets = facets;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName("$facet");
            writer.writeStartDocument();
            for (Facet facet : this.facets) {
                writer.writeName(facet.getName());
                writer.writeStartArray();
                for (Bson bson : facet.getPipeline()) {
                    BuildersHelper.encodeValue(writer, bson, codecRegistry);
                }
                writer.writeEndArray();
            }
            writer.writeEndDocument();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            FacetStage that = (FacetStage) o;
            return this.facets != null ? this.facets.equals(that.facets) : that.facets == null;
        }

        public int hashCode() {
            if (this.facets != null) {
                return this.facets.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Stage{name='$facet', facets=" + this.facets + '}';
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$AddFieldsStage.class */
    public static class AddFieldsStage implements Bson {
        private final List<Field<?>> fields;

        AddFieldsStage(List<Field<?>> fields) {
            this.fields = fields;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName("$addFields");
            writer.writeStartDocument();
            for (Field<?> field : this.fields) {
                writer.writeName(field.getName());
                BuildersHelper.encodeValue(writer, field.getValue(), codecRegistry);
            }
            writer.writeEndDocument();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            AddFieldsStage that = (AddFieldsStage) o;
            return this.fields != null ? this.fields.equals(that.fields) : that.fields == null;
        }

        public int hashCode() {
            if (this.fields != null) {
                return this.fields.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Stage{name='$addFields', fields=" + this.fields + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$ReplaceStage.class */
    private static class ReplaceStage<TExpression> implements Bson {
        private final TExpression value;
        private final boolean replaceWith;

        ReplaceStage(TExpression value) {
            this(value, false);
        }

        ReplaceStage(TExpression value, boolean replaceWith) {
            this.value = value;
            this.replaceWith = replaceWith;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            if (this.replaceWith) {
                writer.writeName("$replaceWith");
                BuildersHelper.encodeValue(writer, this.value, codecRegistry);
            } else {
                writer.writeName("$replaceRoot");
                writer.writeStartDocument();
                writer.writeName("newRoot");
                BuildersHelper.encodeValue(writer, this.value, codecRegistry);
                writer.writeEndDocument();
            }
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ReplaceStage<?> that = (ReplaceStage) o;
            return this.value != null ? this.value.equals(that.value) : that.value == null;
        }

        public int hashCode() {
            if (this.value != null) {
                return this.value.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Stage{name='$replaceRoot', value=" + this.value + '}';
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$MergeStage.class */
    public static class MergeStage implements Bson {
        private final BsonValue intoValue;
        private final MergeOptions options;

        MergeStage(BsonValue intoValue, MergeOptions options) {
            this.intoValue = intoValue;
            this.options = options;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeStartDocument("$merge");
            writer.writeName("into");
            if (this.intoValue.isString()) {
                writer.writeString(this.intoValue.asString().getValue());
            } else {
                writer.writeStartDocument();
                writer.writeString("db", this.intoValue.asDocument().getString("db").getValue());
                writer.writeString("coll", this.intoValue.asDocument().getString("coll").getValue());
                writer.writeEndDocument();
            }
            if (this.options.getUniqueIdentifier() != null) {
                if (this.options.getUniqueIdentifier().size() == 1) {
                    writer.writeString("on", this.options.getUniqueIdentifier().get(0));
                } else {
                    writer.writeStartArray("on");
                    for (String cur : this.options.getUniqueIdentifier()) {
                        writer.writeString(cur);
                    }
                    writer.writeEndArray();
                }
            }
            if (this.options.getVariables() != null) {
                writer.writeStartDocument("let");
                for (Variable<?> variable : this.options.getVariables()) {
                    writer.writeName(variable.getName());
                    BuildersHelper.encodeValue(writer, variable.getValue(), codecRegistry);
                }
                writer.writeEndDocument();
            }
            if (this.options.getWhenMatched() != null) {
                writer.writeName("whenMatched");
                switch (this.options.getWhenMatched()) {
                    case REPLACE:
                        writer.writeString(Parser.REPLACE_CONVERTER_WORD);
                        break;
                    case KEEP_EXISTING:
                        writer.writeString("keepExisting");
                        break;
                    case MERGE:
                        writer.writeString("merge");
                        break;
                    case PIPELINE:
                        writer.writeStartArray();
                        for (Bson curStage : this.options.getWhenMatchedPipeline()) {
                            BuildersHelper.encodeValue(writer, curStage, codecRegistry);
                        }
                        writer.writeEndArray();
                        break;
                    case FAIL:
                        writer.writeString("fail");
                        break;
                    default:
                        throw new UnsupportedOperationException("Unexpected value: " + this.options.getWhenMatched());
                }
            }
            if (this.options.getWhenNotMatched() != null) {
                writer.writeName("whenNotMatched");
                switch (this.options.getWhenNotMatched()) {
                    case INSERT:
                        writer.writeString("insert");
                        break;
                    case DISCARD:
                        writer.writeString("discard");
                        break;
                    case FAIL:
                        writer.writeString("fail");
                        break;
                    default:
                        throw new UnsupportedOperationException("Unexpected value: " + this.options.getWhenNotMatched());
                }
            }
            writer.writeEndDocument();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MergeStage that = (MergeStage) o;
            if (this.intoValue.equals(that.intoValue) && this.options.equals(that.options)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (31 * this.intoValue.hashCode()) + this.options.hashCode();
        }

        public String toString() {
            return "Stage{name='$merge', , into=" + this.intoValue + ", options=" + this.options + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Aggregates$UnionWithStage.class */
    private static final class UnionWithStage implements Bson {
        private final String collection;
        private final List<? extends Bson> pipeline;

        private UnionWithStage(String collection, List<? extends Bson> pipeline) {
            this.collection = collection;
            this.pipeline = pipeline;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeStartDocument("$unionWith");
            writer.writeString("coll", this.collection);
            writer.writeName("pipeline");
            writer.writeStartArray();
            for (Bson stage : this.pipeline) {
                BuildersHelper.encodeValue(writer, stage, codecRegistry);
            }
            writer.writeEndArray();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            UnionWithStage that = (UnionWithStage) o;
            if (!this.collection.equals(that.collection)) {
                return false;
            }
            return this.pipeline != null ? !this.pipeline.equals(that.pipeline) : that.pipeline != null;
        }

        public int hashCode() {
            return (31 * this.collection.hashCode()) + (this.pipeline != null ? this.pipeline.hashCode() : 0);
        }

        public String toString() {
            return "Stage{name='$unionWith', collection='" + this.collection + "', pipeline=" + this.pipeline + '}';
        }
    }

    private Aggregates() {
    }
}
