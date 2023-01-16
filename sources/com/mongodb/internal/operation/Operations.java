package com.mongodb.internal.operation;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.CountOptions;
import com.mongodb.client.model.CreateIndexOptions;
import com.mongodb.client.model.DeleteManyModel;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.DeleteOptions;
import com.mongodb.client.model.DropIndexOptions;
import com.mongodb.client.model.FindOneAndDeleteOptions;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.IndexModel;
import com.mongodb.client.model.InsertManyOptions;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.InsertOneOptions;
import com.mongodb.client.model.MapReduceAction;
import com.mongodb.client.model.RenameCollectionOptions;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.UpdateManyModel;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.WriteModel;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.IndexRequest;
import com.mongodb.internal.bulk.InsertRequest;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.bulk.WriteRequest;
import com.mongodb.internal.client.model.AggregationLevel;
import com.mongodb.internal.client.model.CountStrategy;
import com.mongodb.internal.client.model.FindOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.BsonJavaScript;
import org.bson.BsonString;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/Operations.class */
public final class Operations<TDocument> {
    private final MongoNamespace namespace;
    private final Class<TDocument> documentClass;
    private final ReadPreference readPreference;
    private final CodecRegistry codecRegistry;
    private final ReadConcern readConcern;
    private final WriteConcern writeConcern;
    private final boolean retryWrites;
    private boolean retryReads;

    public Operations(MongoNamespace namespace, Class<TDocument> documentClass, ReadPreference readPreference, CodecRegistry codecRegistry, ReadConcern readConcern, WriteConcern writeConcern, boolean retryWrites, boolean retryReads) {
        this.namespace = namespace;
        this.documentClass = documentClass;
        this.readPreference = readPreference;
        this.codecRegistry = codecRegistry;
        this.readConcern = readConcern;
        this.writeConcern = writeConcern;
        this.retryWrites = retryWrites;
        this.retryReads = retryReads;
    }

    public MongoNamespace getNamespace() {
        return this.namespace;
    }

    public Class<TDocument> getDocumentClass() {
        return this.documentClass;
    }

    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    public CodecRegistry getCodecRegistry() {
        return this.codecRegistry;
    }

    public ReadConcern getReadConcern() {
        return this.readConcern;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public boolean isRetryWrites() {
        return this.retryWrites;
    }

    public boolean isRetryReads() {
        return this.retryReads;
    }

    public CountOperation count(Bson filter, CountOptions options, CountStrategy countStrategy) {
        CountOperation operation = new CountOperation(this.namespace, countStrategy).retryReads(this.retryReads).filter(toBsonDocument(filter)).skip((long) options.getSkip()).limit((long) options.getLimit()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).collation(options.getCollation());
        if (options.getHint() != null) {
            operation.hint(toBsonDocument(options.getHint()));
        } else if (options.getHintString() != null) {
            operation.hint(new BsonString(options.getHintString()));
        }
        return operation;
    }

    public <TResult> FindOperation<TResult> findFirst(Bson filter, Class<TResult> resultClass, FindOptions options) {
        return createFindOperation(this.namespace, filter, resultClass, options).batchSize(0).limit(-1);
    }

    public <TResult> FindOperation<TResult> find(Bson filter, Class<TResult> resultClass, FindOptions options) {
        return createFindOperation(this.namespace, filter, resultClass, options);
    }

    public <TResult> FindOperation<TResult> find(MongoNamespace findNamespace, Bson filter, Class<TResult> resultClass, FindOptions options) {
        return createFindOperation(findNamespace, filter, resultClass, options);
    }

    private <TResult> FindOperation<TResult> createFindOperation(MongoNamespace findNamespace, Bson filter, Class<TResult> resultClass, FindOptions options) {
        FindOperation<TResult> operation = new FindOperation(findNamespace, this.codecRegistry.get(resultClass)).retryReads(this.retryReads).filter(filter == null ? new BsonDocument() : filter.toBsonDocument(this.documentClass, this.codecRegistry)).batchSize(options.getBatchSize()).skip(options.getSkip()).limit(options.getLimit()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).maxAwaitTime(options.getMaxAwaitTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).projection(toBsonDocumentOrNull(options.getProjection())).sort(toBsonDocumentOrNull(options.getSort())).cursorType(options.getCursorType()).noCursorTimeout(options.isNoCursorTimeout()).oplogReplay(options.isOplogReplay()).partial(options.isPartial()).slaveOk(this.readPreference.isSlaveOk()).collation(options.getCollation()).comment(options.getComment()).min(toBsonDocumentOrNull(options.getMin())).max(toBsonDocumentOrNull(options.getMax())).returnKey(options.isReturnKey()).showRecordId(options.isShowRecordId()).allowDiskUse(options.isAllowDiskUse());
        if (options.getHint() != null) {
            operation.hint(toBsonDocument(options.getHint()));
        } else if (options.getHintString() != null) {
            operation.hint(new BsonString(options.getHintString()));
        }
        return operation;
    }

    public <TResult> DistinctOperation<TResult> distinct(String fieldName, Bson filter, Class<TResult> resultClass, long maxTimeMS, Collation collation) {
        return new DistinctOperation(this.namespace, fieldName, this.codecRegistry.get(resultClass)).retryReads(this.retryReads).filter(filter == null ? null : filter.toBsonDocument(this.documentClass, this.codecRegistry)).maxTime(maxTimeMS, TimeUnit.MILLISECONDS).collation(collation);
    }

    public <TResult> AggregateOperation<TResult> aggregate(List<? extends Bson> pipeline, Class<TResult> resultClass, long maxTimeMS, long maxAwaitTimeMS, Integer batchSize, Collation collation, Bson hint, String comment, Boolean allowDiskUse, AggregationLevel aggregationLevel) {
        return new AggregateOperation(this.namespace, toBsonDocumentList(pipeline), this.codecRegistry.get(resultClass), aggregationLevel).retryReads(this.retryReads).maxTime(maxTimeMS, TimeUnit.MILLISECONDS).maxAwaitTime(maxAwaitTimeMS, TimeUnit.MILLISECONDS).allowDiskUse(allowDiskUse).batchSize(batchSize).collation(collation).hint(hint == null ? null : hint.toBsonDocument(this.documentClass, this.codecRegistry)).comment(comment);
    }

    public AggregateToCollectionOperation aggregateToCollection(List<? extends Bson> pipeline, long maxTimeMS, Boolean allowDiskUse, Boolean bypassDocumentValidation, Collation collation, Bson hint, String comment, AggregationLevel aggregationLevel) {
        return new AggregateToCollectionOperation(this.namespace, toBsonDocumentList(pipeline), this.readConcern, this.writeConcern, aggregationLevel).maxTime(maxTimeMS, TimeUnit.MILLISECONDS).allowDiskUse(allowDiskUse).bypassDocumentValidation(bypassDocumentValidation).collation(collation).hint(hint == null ? null : hint.toBsonDocument(this.documentClass, this.codecRegistry)).comment(comment);
    }

    public MapReduceToCollectionOperation mapReduceToCollection(String databaseName, String collectionName, String mapFunction, String reduceFunction, String finalizeFunction, Bson filter, int limit, long maxTimeMS, boolean jsMode, Bson scope, Bson sort, boolean verbose, MapReduceAction action, boolean nonAtomic, boolean sharded, Boolean bypassDocumentValidation, Collation collation) {
        MapReduceToCollectionOperation operation = new MapReduceToCollectionOperation(this.namespace, new BsonJavaScript(mapFunction), new BsonJavaScript(reduceFunction), collectionName, this.writeConcern).filter(toBsonDocumentOrNull(filter)).limit(limit).maxTime(maxTimeMS, TimeUnit.MILLISECONDS).jsMode(jsMode).scope(toBsonDocumentOrNull(scope)).sort(toBsonDocumentOrNull(sort)).verbose(verbose).action(action.getValue()).nonAtomic(nonAtomic).sharded(sharded).databaseName(databaseName).bypassDocumentValidation(bypassDocumentValidation).collation(collation);
        if (finalizeFunction != null) {
            operation.finalizeFunction(new BsonJavaScript(finalizeFunction));
        }
        return operation;
    }

    public <TResult> MapReduceWithInlineResultsOperation<TResult> mapReduce(String mapFunction, String reduceFunction, String finalizeFunction, Class<TResult> resultClass, Bson filter, int limit, long maxTimeMS, boolean jsMode, Bson scope, Bson sort, boolean verbose, Collation collation) {
        MapReduceWithInlineResultsOperation<TResult> operation = new MapReduceWithInlineResultsOperation(this.namespace, new BsonJavaScript(mapFunction), new BsonJavaScript(reduceFunction), this.codecRegistry.get(resultClass)).filter(toBsonDocumentOrNull(filter)).limit(limit).maxTime(maxTimeMS, TimeUnit.MILLISECONDS).jsMode(jsMode).scope(toBsonDocumentOrNull(scope)).sort(toBsonDocumentOrNull(sort)).verbose(verbose).collation(collation);
        if (finalizeFunction != null) {
            operation.finalizeFunction(new BsonJavaScript(finalizeFunction));
        }
        return operation;
    }

    public FindAndDeleteOperation<TDocument> findOneAndDelete(Bson filter, FindOneAndDeleteOptions options) {
        return new FindAndDeleteOperation(this.namespace, this.writeConcern, this.retryWrites, getCodec()).filter(toBsonDocument(filter)).projection(toBsonDocument(options.getProjection())).sort(toBsonDocument(options.getSort())).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).collation(options.getCollation()).hint(options.getHint()).hintString(options.getHintString());
    }

    public FindAndReplaceOperation<TDocument> findOneAndReplace(Bson filter, TDocument replacement, FindOneAndReplaceOptions options) {
        return new FindAndReplaceOperation(this.namespace, this.writeConcern, this.retryWrites, getCodec(), documentToBsonDocument(replacement)).filter(toBsonDocument(filter)).projection(toBsonDocument(options.getProjection())).sort(toBsonDocument(options.getSort())).returnOriginal(options.getReturnDocument() == ReturnDocument.BEFORE).upsert(options.isUpsert()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).bypassDocumentValidation(options.getBypassDocumentValidation()).collation(options.getCollation()).hint(options.getHint()).hintString(options.getHintString());
    }

    public FindAndUpdateOperation<TDocument> findOneAndUpdate(Bson filter, Bson update, FindOneAndUpdateOptions options) {
        return new FindAndUpdateOperation(this.namespace, this.writeConcern, this.retryWrites, getCodec(), toBsonDocument(update)).filter(toBsonDocument(filter)).projection(toBsonDocument(options.getProjection())).sort(toBsonDocument(options.getSort())).returnOriginal(options.getReturnDocument() == ReturnDocument.BEFORE).upsert(options.isUpsert()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).bypassDocumentValidation(options.getBypassDocumentValidation()).collation(options.getCollation()).arrayFilters(toBsonDocumentList(options.getArrayFilters())).hint(options.getHint()).hintString(options.getHintString());
    }

    public FindAndUpdateOperation<TDocument> findOneAndUpdate(Bson filter, List<? extends Bson> update, FindOneAndUpdateOptions options) {
        return new FindAndUpdateOperation(this.namespace, this.writeConcern, this.retryWrites, getCodec(), toBsonDocumentList(update)).filter(toBsonDocument(filter)).projection(toBsonDocument(options.getProjection())).sort(toBsonDocument(options.getSort())).returnOriginal(options.getReturnDocument() == ReturnDocument.BEFORE).upsert(options.isUpsert()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).bypassDocumentValidation(options.getBypassDocumentValidation()).collation(options.getCollation()).arrayFilters(toBsonDocumentList(options.getArrayFilters())).hint(options.getHint()).hintString(options.getHintString());
    }

    public MixedBulkWriteOperation insertOne(TDocument document, InsertOneOptions options) {
        return bulkWrite(Collections.singletonList(new InsertOneModel(document)), new BulkWriteOptions().bypassDocumentValidation(options.getBypassDocumentValidation()));
    }

    public MixedBulkWriteOperation replaceOne(Bson filter, TDocument replacement, ReplaceOptions options) {
        return bulkWrite(Collections.singletonList(new ReplaceOneModel(filter, replacement, options)), new BulkWriteOptions().bypassDocumentValidation(options.getBypassDocumentValidation()));
    }

    public MixedBulkWriteOperation deleteOne(Bson filter, DeleteOptions options) {
        return bulkWrite(Collections.singletonList(new DeleteOneModel(filter, options)), new BulkWriteOptions());
    }

    public MixedBulkWriteOperation deleteMany(Bson filter, DeleteOptions options) {
        return bulkWrite(Collections.singletonList(new DeleteManyModel(filter, options)), new BulkWriteOptions());
    }

    public MixedBulkWriteOperation updateOne(Bson filter, Bson update, UpdateOptions updateOptions) {
        return bulkWrite(Collections.singletonList(new UpdateOneModel(filter, update, updateOptions)), new BulkWriteOptions().bypassDocumentValidation(updateOptions.getBypassDocumentValidation()));
    }

    public MixedBulkWriteOperation updateOne(Bson filter, List<? extends Bson> update, UpdateOptions updateOptions) {
        return bulkWrite(Collections.singletonList(new UpdateOneModel(filter, update, updateOptions)), new BulkWriteOptions().bypassDocumentValidation(updateOptions.getBypassDocumentValidation()));
    }

    public MixedBulkWriteOperation updateMany(Bson filter, Bson update, UpdateOptions updateOptions) {
        return bulkWrite(Collections.singletonList(new UpdateManyModel(filter, update, updateOptions)), new BulkWriteOptions().bypassDocumentValidation(updateOptions.getBypassDocumentValidation()));
    }

    public MixedBulkWriteOperation updateMany(Bson filter, List<? extends Bson> update, UpdateOptions updateOptions) {
        return bulkWrite(Collections.singletonList(new UpdateManyModel(filter, update, updateOptions)), new BulkWriteOptions().bypassDocumentValidation(updateOptions.getBypassDocumentValidation()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.mongodb.internal.operation.Operations<TDocument> */
    /* JADX WARN: Multi-variable type inference failed */
    public MixedBulkWriteOperation insertMany(List<? extends TDocument> documents, InsertManyOptions options) {
        Assertions.notNull("documents", documents);
        List<InsertRequest> requests = new ArrayList<>(documents.size());
        for (Object obj : documents) {
            if (obj == null) {
                throw new IllegalArgumentException("documents can not contain a null value");
            }
            if (getCodec() instanceof CollectibleCodec) {
                obj = ((CollectibleCodec) getCodec()).generateIdIfAbsentFromDocument(obj);
            }
            requests.add(new InsertRequest(documentToBsonDocument(obj)));
        }
        return new MixedBulkWriteOperation(this.namespace, requests, options.isOrdered(), this.writeConcern, this.retryWrites).bypassDocumentValidation(options.getBypassDocumentValidation());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.mongodb.internal.operation.Operations<TDocument> */
    /* JADX WARN: Multi-variable type inference failed */
    public MixedBulkWriteOperation bulkWrite(List<? extends WriteModel<? extends TDocument>> requests, BulkWriteOptions options) {
        WriteRequest writeRequest;
        Assertions.notNull("requests", requests);
        List<WriteRequest> writeRequests = new ArrayList<>(requests.size());
        for (WriteModel<? extends TDocument> writeModel : requests) {
            if (writeModel == null) {
                throw new IllegalArgumentException("requests can not contain a null value");
            }
            if (writeModel instanceof InsertOneModel) {
                Object document = ((InsertOneModel) writeModel).getDocument();
                if (getCodec() instanceof CollectibleCodec) {
                    document = ((CollectibleCodec) getCodec()).generateIdIfAbsentFromDocument(document);
                }
                writeRequest = new InsertRequest(documentToBsonDocument(document));
            } else if (writeModel instanceof ReplaceOneModel) {
                ReplaceOneModel<TDocument> replaceOneModel = (ReplaceOneModel) writeModel;
                writeRequest = new UpdateRequest(toBsonDocument(replaceOneModel.getFilter()), documentToBsonDocument(replaceOneModel.getReplacement()), WriteRequest.Type.REPLACE).upsert(replaceOneModel.getReplaceOptions().isUpsert()).collation(replaceOneModel.getReplaceOptions().getCollation()).hint(replaceOneModel.getReplaceOptions().getHint()).hintString(replaceOneModel.getReplaceOptions().getHintString());
            } else if (writeModel instanceof UpdateOneModel) {
                UpdateOneModel<TDocument> updateOneModel = (UpdateOneModel) writeModel;
                writeRequest = new UpdateRequest(toBsonDocument(updateOneModel.getFilter()), updateOneModel.getUpdate() != null ? toBsonDocument(updateOneModel.getUpdate()) : new BsonArray(toBsonDocumentList(updateOneModel.getUpdatePipeline())), WriteRequest.Type.UPDATE).multi(false).upsert(updateOneModel.getOptions().isUpsert()).collation(updateOneModel.getOptions().getCollation()).arrayFilters(toBsonDocumentList(updateOneModel.getOptions().getArrayFilters())).hint(updateOneModel.getOptions().getHint()).hintString(updateOneModel.getOptions().getHintString());
            } else if (writeModel instanceof UpdateManyModel) {
                UpdateManyModel<TDocument> updateManyModel = (UpdateManyModel) writeModel;
                writeRequest = new UpdateRequest(toBsonDocument(updateManyModel.getFilter()), updateManyModel.getUpdate() != null ? toBsonDocument(updateManyModel.getUpdate()) : new BsonArray(toBsonDocumentList(updateManyModel.getUpdatePipeline())), WriteRequest.Type.UPDATE).multi(true).upsert(updateManyModel.getOptions().isUpsert()).collation(updateManyModel.getOptions().getCollation()).arrayFilters(toBsonDocumentList(updateManyModel.getOptions().getArrayFilters())).hint(updateManyModel.getOptions().getHint()).hintString(updateManyModel.getOptions().getHintString());
            } else if (writeModel instanceof DeleteOneModel) {
                DeleteOneModel<TDocument> deleteOneModel = (DeleteOneModel) writeModel;
                writeRequest = new DeleteRequest(toBsonDocument(deleteOneModel.getFilter())).multi(false).collation(deleteOneModel.getOptions().getCollation()).hint(deleteOneModel.getOptions().getHint()).hintString(deleteOneModel.getOptions().getHintString());
            } else if (writeModel instanceof DeleteManyModel) {
                DeleteManyModel<TDocument> deleteManyModel = (DeleteManyModel) writeModel;
                writeRequest = new DeleteRequest(toBsonDocument(deleteManyModel.getFilter())).multi(true).collation(deleteManyModel.getOptions().getCollation()).hint(deleteManyModel.getOptions().getHint()).hintString(deleteManyModel.getOptions().getHintString());
            } else {
                throw new UnsupportedOperationException(String.format("WriteModel of type %s is not supported", writeModel.getClass()));
            }
            writeRequests.add(writeRequest);
        }
        return new MixedBulkWriteOperation(this.namespace, writeRequests, options.isOrdered(), this.writeConcern, this.retryWrites).bypassDocumentValidation(options.getBypassDocumentValidation());
    }

    public DropCollectionOperation dropCollection() {
        return new DropCollectionOperation(this.namespace, this.writeConcern);
    }

    public RenameCollectionOperation renameCollection(MongoNamespace newCollectionNamespace, RenameCollectionOptions renameCollectionOptions) {
        return new RenameCollectionOperation(this.namespace, newCollectionNamespace, this.writeConcern).dropTarget(renameCollectionOptions.isDropTarget());
    }

    public CreateIndexesOperation createIndexes(List<IndexModel> indexes, CreateIndexOptions createIndexOptions) {
        Assertions.notNull("indexes", indexes);
        Assertions.notNull("createIndexOptions", createIndexOptions);
        List<IndexRequest> indexRequests = new ArrayList<>(indexes.size());
        for (IndexModel model : indexes) {
            if (model == null) {
                throw new IllegalArgumentException("indexes can not contain a null value");
            }
            indexRequests.add(new IndexRequest(toBsonDocument(model.getKeys())).name(model.getOptions().getName()).background(model.getOptions().isBackground()).unique(model.getOptions().isUnique()).sparse(model.getOptions().isSparse()).expireAfter(model.getOptions().getExpireAfter(TimeUnit.SECONDS), TimeUnit.SECONDS).version(model.getOptions().getVersion()).weights(toBsonDocument(model.getOptions().getWeights())).defaultLanguage(model.getOptions().getDefaultLanguage()).languageOverride(model.getOptions().getLanguageOverride()).textVersion(model.getOptions().getTextVersion()).sphereVersion(model.getOptions().getSphereVersion()).bits(model.getOptions().getBits()).min(model.getOptions().getMin()).max(model.getOptions().getMax()).bucketSize(model.getOptions().getBucketSize()).storageEngine(toBsonDocument(model.getOptions().getStorageEngine())).partialFilterExpression(toBsonDocument(model.getOptions().getPartialFilterExpression())).collation(model.getOptions().getCollation()).wildcardProjection(toBsonDocument(model.getOptions().getWildcardProjection())).hidden(model.getOptions().isHidden()));
        }
        return new CreateIndexesOperation(this.namespace, indexRequests, this.writeConcern).maxTime(createIndexOptions.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).commitQuorum(createIndexOptions.getCommitQuorum());
    }

    public DropIndexOperation dropIndex(String indexName, DropIndexOptions dropIndexOptions) {
        return new DropIndexOperation(this.namespace, indexName, this.writeConcern).maxTime(dropIndexOptions.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS);
    }

    public DropIndexOperation dropIndex(Bson keys, DropIndexOptions dropIndexOptions) {
        return new DropIndexOperation(this.namespace, keys.toBsonDocument(BsonDocument.class, this.codecRegistry), this.writeConcern).maxTime(dropIndexOptions.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS);
    }

    public <TResult> ListCollectionsOperation<TResult> listCollections(String databaseName, Class<TResult> resultClass, Bson filter, boolean collectionNamesOnly, Integer batchSize, long maxTimeMS) {
        return new ListCollectionsOperation(databaseName, this.codecRegistry.get(resultClass)).retryReads(this.retryReads).filter(toBsonDocumentOrNull(filter)).nameOnly(collectionNamesOnly).batchSize(batchSize == null ? 0 : batchSize.intValue()).maxTime(maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public <TResult> ListDatabasesOperation<TResult> listDatabases(Class<TResult> resultClass, Bson filter, Boolean nameOnly, long maxTimeMS, Boolean authorizedDatabasesOnly) {
        return new ListDatabasesOperation(this.codecRegistry.get(resultClass)).maxTime(maxTimeMS, TimeUnit.MILLISECONDS).retryReads(this.retryReads).filter(toBsonDocumentOrNull(filter)).nameOnly(nameOnly).authorizedDatabasesOnly(authorizedDatabasesOnly);
    }

    public <TResult> ListIndexesOperation<TResult> listIndexes(Class<TResult> resultClass, Integer batchSize, long maxTimeMS) {
        return new ListIndexesOperation(this.namespace, this.codecRegistry.get(resultClass)).retryReads(this.retryReads).batchSize(batchSize == null ? 0 : batchSize.intValue()).maxTime(maxTimeMS, TimeUnit.MILLISECONDS);
    }

    private Codec<TDocument> getCodec() {
        return this.codecRegistry.get(this.documentClass);
    }

    private BsonDocument documentToBsonDocument(TDocument document) {
        return BsonDocumentWrapper.asBsonDocument(document, this.codecRegistry);
    }

    private BsonDocument toBsonDocument(Bson bson) {
        if (bson == null) {
            return null;
        }
        return bson.toBsonDocument(this.documentClass, this.codecRegistry);
    }

    private List<BsonDocument> toBsonDocumentList(List<? extends Bson> bsonList) {
        if (bsonList == null) {
            return null;
        }
        List<BsonDocument> bsonDocumentList = new ArrayList<>(bsonList.size());
        for (Bson cur : bsonList) {
            bsonDocumentList.add(toBsonDocument(cur));
        }
        return bsonDocumentList;
    }

    BsonDocument toBsonDocumentOrNull(Bson document) {
        if (document == null) {
            return null;
        }
        return document.toBsonDocument(this.documentClass, this.codecRegistry);
    }
}
