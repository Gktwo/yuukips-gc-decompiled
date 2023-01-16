package com.mongodb.client.internal;

import com.mongodb.MongoBulkWriteException;
import com.mongodb.MongoException;
import com.mongodb.MongoInternalException;
import com.mongodb.MongoNamespace;
import com.mongodb.MongoWriteConcernException;
import com.mongodb.MongoWriteException;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.WriteConcernResult;
import com.mongodb.WriteError;
import com.mongodb.assertions.Assertions;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.ClientSession;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListIndexesIterable;
import com.mongodb.client.MapReduceIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.CountOptions;
import com.mongodb.client.model.CreateIndexOptions;
import com.mongodb.client.model.DeleteOptions;
import com.mongodb.client.model.DropIndexOptions;
import com.mongodb.client.model.EstimatedDocumentCountOptions;
import com.mongodb.client.model.FindOneAndDeleteOptions;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.IndexModel;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.InsertManyOptions;
import com.mongodb.client.model.InsertOneOptions;
import com.mongodb.client.model.RenameCollectionOptions;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.WriteModel;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.internal.bulk.WriteRequest;
import com.mongodb.internal.client.model.AggregationLevel;
import com.mongodb.internal.client.model.CountOptionsHelper;
import com.mongodb.internal.client.model.CountStrategy;
import com.mongodb.internal.client.model.changestream.ChangeStreamLevel;
import com.mongodb.internal.operation.IndexHelper;
import com.mongodb.internal.operation.RenameCollectionOperation;
import com.mongodb.internal.operation.SyncOperations;
import com.mongodb.internal.operation.WriteOperation;
import com.mongodb.lang.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.internal.CodecRegistryHelper;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/internal/MongoCollectionImpl.class */
public class MongoCollectionImpl<TDocument> implements MongoCollection<TDocument> {
    private final MongoNamespace namespace;
    private final Class<TDocument> documentClass;
    private final ReadPreference readPreference;
    private final CodecRegistry codecRegistry;
    private final WriteConcern writeConcern;
    private final boolean retryWrites;
    private final boolean retryReads;
    private final ReadConcern readConcern;
    private final SyncOperations<TDocument> operations;
    private final UuidRepresentation uuidRepresentation;
    private final OperationExecutor executor;

    /* access modifiers changed from: package-private */
    public MongoCollectionImpl(MongoNamespace namespace, Class<TDocument> documentClass, CodecRegistry codecRegistry, ReadPreference readPreference, WriteConcern writeConcern, boolean retryWrites, boolean retryReads, ReadConcern readConcern, UuidRepresentation uuidRepresentation, OperationExecutor executor) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.documentClass = (Class) Assertions.notNull("documentClass", documentClass);
        this.codecRegistry = (CodecRegistry) Assertions.notNull("codecRegistry", codecRegistry);
        this.readPreference = (ReadPreference) Assertions.notNull("readPreference", readPreference);
        this.writeConcern = (WriteConcern) Assertions.notNull("writeConcern", writeConcern);
        this.retryWrites = retryWrites;
        this.retryReads = retryReads;
        this.readConcern = (ReadConcern) Assertions.notNull("readConcern", readConcern);
        this.executor = (OperationExecutor) Assertions.notNull("executor", executor);
        this.uuidRepresentation = (UuidRepresentation) Assertions.notNull("uuidRepresentation", uuidRepresentation);
        this.operations = new SyncOperations<>(namespace, documentClass, readPreference, codecRegistry, readConcern, writeConcern, retryWrites, retryReads);
    }

    @Override // com.mongodb.client.MongoCollection
    public MongoNamespace getNamespace() {
        return this.namespace;
    }

    @Override // com.mongodb.client.MongoCollection
    public Class<TDocument> getDocumentClass() {
        return this.documentClass;
    }

    @Override // com.mongodb.client.MongoCollection
    public CodecRegistry getCodecRegistry() {
        return this.codecRegistry;
    }

    @Override // com.mongodb.client.MongoCollection
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    @Override // com.mongodb.client.MongoCollection
    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    @Override // com.mongodb.client.MongoCollection
    public ReadConcern getReadConcern() {
        return this.readConcern;
    }

    @Override // com.mongodb.client.MongoCollection
    public <NewTDocument> MongoCollection<NewTDocument> withDocumentClass(Class<NewTDocument> clazz) {
        return new MongoCollectionImpl(this.namespace, clazz, this.codecRegistry, this.readPreference, this.writeConcern, this.retryWrites, this.retryReads, this.readConcern, this.uuidRepresentation, this.executor);
    }

    @Override // com.mongodb.client.MongoCollection
    public MongoCollection<TDocument> withCodecRegistry(CodecRegistry codecRegistry) {
        return new MongoCollectionImpl(this.namespace, this.documentClass, CodecRegistryHelper.createRegistry(codecRegistry, this.uuidRepresentation), this.readPreference, this.writeConcern, this.retryWrites, this.retryReads, this.readConcern, this.uuidRepresentation, this.executor);
    }

    @Override // com.mongodb.client.MongoCollection
    public MongoCollection<TDocument> withReadPreference(ReadPreference readPreference) {
        return new MongoCollectionImpl(this.namespace, this.documentClass, this.codecRegistry, readPreference, this.writeConcern, this.retryWrites, this.retryReads, this.readConcern, this.uuidRepresentation, this.executor);
    }

    @Override // com.mongodb.client.MongoCollection
    public MongoCollection<TDocument> withWriteConcern(WriteConcern writeConcern) {
        return new MongoCollectionImpl(this.namespace, this.documentClass, this.codecRegistry, this.readPreference, writeConcern, this.retryWrites, this.retryReads, this.readConcern, this.uuidRepresentation, this.executor);
    }

    @Override // com.mongodb.client.MongoCollection
    public MongoCollection<TDocument> withReadConcern(ReadConcern readConcern) {
        return new MongoCollectionImpl(this.namespace, this.documentClass, this.codecRegistry, this.readPreference, this.writeConcern, this.retryWrites, this.retryReads, readConcern, this.uuidRepresentation, this.executor);
    }

    @Override // com.mongodb.client.MongoCollection
    public long countDocuments() {
        return countDocuments(new BsonDocument());
    }

    @Override // com.mongodb.client.MongoCollection
    public long countDocuments(Bson filter) {
        return countDocuments(filter, new CountOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public long countDocuments(Bson filter, CountOptions options) {
        return executeCount(null, filter, options, CountStrategy.AGGREGATE);
    }

    @Override // com.mongodb.client.MongoCollection
    public long countDocuments(ClientSession clientSession) {
        return countDocuments(clientSession, new BsonDocument());
    }

    @Override // com.mongodb.client.MongoCollection
    public long countDocuments(ClientSession clientSession, Bson filter) {
        return countDocuments(clientSession, filter, new CountOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public long countDocuments(ClientSession clientSession, Bson filter, CountOptions options) {
        Assertions.notNull("clientSession", clientSession);
        return executeCount(clientSession, filter, options, CountStrategy.AGGREGATE);
    }

    @Override // com.mongodb.client.MongoCollection
    public long estimatedDocumentCount() {
        return estimatedDocumentCount(new EstimatedDocumentCountOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public long estimatedDocumentCount(EstimatedDocumentCountOptions options) {
        return executeCount(null, new BsonDocument(), CountOptionsHelper.fromEstimatedDocumentCountOptions(options), CountStrategy.COMMAND);
    }

    private long executeCount(@Nullable ClientSession clientSession, Bson filter, CountOptions options, CountStrategy countStrategy) {
        return ((Long) this.executor.execute(this.operations.count(filter, options, countStrategy), this.readPreference, this.readConcern, clientSession)).longValue();
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> DistinctIterable<TResult> distinct(String fieldName, Class<TResult> resultClass) {
        return distinct(fieldName, new BsonDocument(), resultClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> DistinctIterable<TResult> distinct(String fieldName, Bson filter, Class<TResult> resultClass) {
        return createDistinctIterable(null, fieldName, filter, resultClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> DistinctIterable<TResult> distinct(ClientSession clientSession, String fieldName, Class<TResult> resultClass) {
        return distinct(clientSession, fieldName, new BsonDocument(), resultClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> DistinctIterable<TResult> distinct(ClientSession clientSession, String fieldName, Bson filter, Class<TResult> resultClass) {
        Assertions.notNull("clientSession", clientSession);
        return createDistinctIterable(clientSession, fieldName, filter, resultClass);
    }

    private <TResult> DistinctIterable<TResult> createDistinctIterable(@Nullable ClientSession clientSession, String fieldName, Bson filter, Class<TResult> resultClass) {
        return new DistinctIterableImpl(clientSession, this.namespace, this.documentClass, resultClass, this.codecRegistry, this.readPreference, this.readConcern, this.executor, fieldName, filter, this.retryReads);
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public FindIterable<TDocument> find() {
        return (FindIterable<TDocument>) find(new BsonDocument(), (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> FindIterable<TResult> find(Class<TResult> resultClass) {
        return find(new BsonDocument(), resultClass);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public FindIterable<TDocument> find(Bson filter) {
        return (FindIterable<TDocument>) find(filter, (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> FindIterable<TResult> find(Bson filter, Class<TResult> resultClass) {
        return createFindIterable(null, filter, resultClass);
    }

    /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public FindIterable<TDocument> find(ClientSession clientSession) {
        Assertions.notNull("clientSession", clientSession);
        return (FindIterable<TDocument>) find(clientSession, new BsonDocument(), (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> FindIterable<TResult> find(ClientSession clientSession, Class<TResult> resultClass) {
        Assertions.notNull("clientSession", clientSession);
        return find(clientSession, new BsonDocument(), resultClass);
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public FindIterable<TDocument> find(ClientSession clientSession, Bson filter) {
        Assertions.notNull("clientSession", clientSession);
        return (FindIterable<TDocument>) find(clientSession, filter, (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> FindIterable<TResult> find(ClientSession clientSession, Bson filter, Class<TResult> resultClass) {
        Assertions.notNull("clientSession", clientSession);
        return createFindIterable(clientSession, filter, resultClass);
    }

    private <TResult> FindIterable<TResult> createFindIterable(@Nullable ClientSession clientSession, Bson filter, Class<TResult> resultClass) {
        return new FindIterableImpl(clientSession, this.namespace, this.documentClass, resultClass, this.codecRegistry, this.readPreference, this.readConcern, this.executor, filter, this.retryReads);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public AggregateIterable<TDocument> aggregate(List<? extends Bson> pipeline) {
        return (AggregateIterable<TDocument>) aggregate(pipeline, (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> AggregateIterable<TResult> aggregate(List<? extends Bson> pipeline, Class<TResult> resultClass) {
        return createAggregateIterable(null, pipeline, resultClass);
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public AggregateIterable<TDocument> aggregate(ClientSession clientSession, List<? extends Bson> pipeline) {
        return (AggregateIterable<TDocument>) aggregate(clientSession, pipeline, (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> AggregateIterable<TResult> aggregate(ClientSession clientSession, List<? extends Bson> pipeline, Class<TResult> resultClass) {
        Assertions.notNull("clientSession", clientSession);
        return createAggregateIterable(clientSession, pipeline, resultClass);
    }

    private <TResult> AggregateIterable<TResult> createAggregateIterable(@Nullable ClientSession clientSession, List<? extends Bson> pipeline, Class<TResult> resultClass) {
        return new AggregateIterableImpl(clientSession, this.namespace, this.documentClass, resultClass, this.codecRegistry, this.readPreference, this.readConcern, this.writeConcern, this.executor, pipeline, AggregationLevel.COLLECTION, this.retryReads);
    }

    @Override // com.mongodb.client.MongoCollection
    public ChangeStreamIterable<TDocument> watch() {
        return watch(Collections.emptyList());
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> ChangeStreamIterable<TResult> watch(Class<TResult> resultClass) {
        return watch(Collections.emptyList(), resultClass);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public ChangeStreamIterable<TDocument> watch(List<? extends Bson> pipeline) {
        return (ChangeStreamIterable<TDocument>) watch(pipeline, (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> ChangeStreamIterable<TResult> watch(List<? extends Bson> pipeline, Class<TResult> resultClass) {
        return createChangeStreamIterable(null, pipeline, resultClass);
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public ChangeStreamIterable<TDocument> watch(ClientSession clientSession) {
        return (ChangeStreamIterable<TDocument>) watch(clientSession, Collections.emptyList(), (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, Class<TResult> resultClass) {
        return watch(clientSession, Collections.emptyList(), resultClass);
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public ChangeStreamIterable<TDocument> watch(ClientSession clientSession, List<? extends Bson> pipeline) {
        return (ChangeStreamIterable<TDocument>) watch(clientSession, pipeline, (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, List<? extends Bson> pipeline, Class<TResult> resultClass) {
        Assertions.notNull("clientSession", clientSession);
        return createChangeStreamIterable(clientSession, pipeline, resultClass);
    }

    private <TResult> ChangeStreamIterable<TResult> createChangeStreamIterable(@Nullable ClientSession clientSession, List<? extends Bson> pipeline, Class<TResult> resultClass) {
        return new ChangeStreamIterableImpl(clientSession, this.namespace, this.codecRegistry, this.readPreference, this.readConcern, this.executor, pipeline, resultClass, ChangeStreamLevel.COLLECTION, this.retryReads);
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public MapReduceIterable<TDocument> mapReduce(String mapFunction, String reduceFunction) {
        return (MapReduceIterable<TDocument>) mapReduce(mapFunction, reduceFunction, (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> MapReduceIterable<TResult> mapReduce(String mapFunction, String reduceFunction, Class<TResult> resultClass) {
        return createMapReduceIterable(null, mapFunction, reduceFunction, resultClass);
    }

    /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: java.lang.Class<TDocument>, java.lang.Class<TResult> */
    @Override // com.mongodb.client.MongoCollection
    public MapReduceIterable<TDocument> mapReduce(ClientSession clientSession, String mapFunction, String reduceFunction) {
        return (MapReduceIterable<TDocument>) mapReduce(clientSession, mapFunction, reduceFunction, (Class<TDocument>) this.documentClass);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> MapReduceIterable<TResult> mapReduce(ClientSession clientSession, String mapFunction, String reduceFunction, Class<TResult> resultClass) {
        Assertions.notNull("clientSession", clientSession);
        return createMapReduceIterable(clientSession, mapFunction, reduceFunction, resultClass);
    }

    private <TResult> MapReduceIterable<TResult> createMapReduceIterable(@Nullable ClientSession clientSession, String mapFunction, String reduceFunction, Class<TResult> resultClass) {
        return new MapReduceIterableImpl(clientSession, this.namespace, this.documentClass, resultClass, this.codecRegistry, this.readPreference, this.readConcern, this.writeConcern, this.executor, mapFunction, reduceFunction);
    }

    @Override // com.mongodb.client.MongoCollection
    public BulkWriteResult bulkWrite(List<? extends WriteModel<? extends TDocument>> requests) {
        return bulkWrite(requests, new BulkWriteOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public BulkWriteResult bulkWrite(List<? extends WriteModel<? extends TDocument>> requests, BulkWriteOptions options) {
        return executeBulkWrite(null, requests, options);
    }

    @Override // com.mongodb.client.MongoCollection
    public BulkWriteResult bulkWrite(ClientSession clientSession, List<? extends WriteModel<? extends TDocument>> requests) {
        return bulkWrite(clientSession, requests, new BulkWriteOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public BulkWriteResult bulkWrite(ClientSession clientSession, List<? extends WriteModel<? extends TDocument>> requests, BulkWriteOptions options) {
        Assertions.notNull("clientSession", clientSession);
        return executeBulkWrite(clientSession, requests, options);
    }

    private BulkWriteResult executeBulkWrite(@Nullable ClientSession clientSession, List<? extends WriteModel<? extends TDocument>> requests, BulkWriteOptions options) {
        Assertions.notNull("requests", requests);
        return (BulkWriteResult) this.executor.execute(this.operations.bulkWrite(requests, options), this.readConcern, clientSession);
    }

    @Override // com.mongodb.client.MongoCollection
    public InsertOneResult insertOne(TDocument document) {
        return insertOne((MongoCollectionImpl<TDocument>) document, new InsertOneOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public InsertOneResult insertOne(TDocument document, InsertOneOptions options) {
        Assertions.notNull("document", document);
        return executeInsertOne(null, document, options);
    }

    @Override // com.mongodb.client.MongoCollection
    public InsertOneResult insertOne(ClientSession clientSession, TDocument document) {
        return insertOne(clientSession, document, new InsertOneOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public InsertOneResult insertOne(ClientSession clientSession, TDocument document, InsertOneOptions options) {
        Assertions.notNull("clientSession", clientSession);
        Assertions.notNull("document", document);
        return executeInsertOne(clientSession, document, options);
    }

    private InsertOneResult executeInsertOne(@Nullable ClientSession clientSession, TDocument document, InsertOneOptions options) {
        return toInsertOneResult(executeSingleWriteRequest(clientSession, this.operations.insertOne(document, options), WriteRequest.Type.INSERT));
    }

    @Override // com.mongodb.client.MongoCollection
    public InsertManyResult insertMany(List<? extends TDocument> documents) {
        return insertMany(documents, new InsertManyOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public InsertManyResult insertMany(List<? extends TDocument> documents, InsertManyOptions options) {
        return executeInsertMany(null, documents, options);
    }

    @Override // com.mongodb.client.MongoCollection
    public InsertManyResult insertMany(ClientSession clientSession, List<? extends TDocument> documents) {
        return insertMany(clientSession, documents, new InsertManyOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public InsertManyResult insertMany(ClientSession clientSession, List<? extends TDocument> documents, InsertManyOptions options) {
        Assertions.notNull("clientSession", clientSession);
        return executeInsertMany(clientSession, documents, options);
    }

    private InsertManyResult executeInsertMany(@Nullable ClientSession clientSession, List<? extends TDocument> documents, InsertManyOptions options) {
        return toInsertManyResult((BulkWriteResult) this.executor.execute(this.operations.insertMany(documents, options), this.readConcern, clientSession));
    }

    @Override // com.mongodb.client.MongoCollection
    public DeleteResult deleteOne(Bson filter) {
        return deleteOne(filter, new DeleteOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public DeleteResult deleteOne(Bson filter, DeleteOptions options) {
        return executeDelete(null, filter, options, false);
    }

    @Override // com.mongodb.client.MongoCollection
    public DeleteResult deleteOne(ClientSession clientSession, Bson filter) {
        return deleteOne(clientSession, filter, new DeleteOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public DeleteResult deleteOne(ClientSession clientSession, Bson filter, DeleteOptions options) {
        Assertions.notNull("clientSession", clientSession);
        return executeDelete(clientSession, filter, options, false);
    }

    @Override // com.mongodb.client.MongoCollection
    public DeleteResult deleteMany(Bson filter) {
        return deleteMany(filter, new DeleteOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public DeleteResult deleteMany(Bson filter, DeleteOptions options) {
        return executeDelete(null, filter, options, true);
    }

    @Override // com.mongodb.client.MongoCollection
    public DeleteResult deleteMany(ClientSession clientSession, Bson filter) {
        return deleteMany(clientSession, filter, new DeleteOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public DeleteResult deleteMany(ClientSession clientSession, Bson filter, DeleteOptions options) {
        Assertions.notNull("clientSession", clientSession);
        return executeDelete(clientSession, filter, options, true);
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult replaceOne(Bson filter, TDocument replacement) {
        return replaceOne(filter, (Bson) replacement, new ReplaceOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult replaceOne(Bson filter, TDocument replacement, ReplaceOptions replaceOptions) {
        return executeReplaceOne(null, filter, replacement, replaceOptions);
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult replaceOne(ClientSession clientSession, Bson filter, TDocument replacement) {
        return replaceOne(clientSession, filter, replacement, new ReplaceOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult replaceOne(ClientSession clientSession, Bson filter, TDocument replacement, ReplaceOptions replaceOptions) {
        Assertions.notNull("clientSession", clientSession);
        return executeReplaceOne(clientSession, filter, replacement, replaceOptions);
    }

    private UpdateResult executeReplaceOne(@Nullable ClientSession clientSession, Bson filter, TDocument replacement, ReplaceOptions replaceOptions) {
        return toUpdateResult(executeSingleWriteRequest(clientSession, this.operations.replaceOne(filter, replacement, replaceOptions), WriteRequest.Type.REPLACE));
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateOne(Bson filter, Bson update) {
        return updateOne(filter, update, new UpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateOne(Bson filter, Bson update, UpdateOptions updateOptions) {
        return executeUpdate((ClientSession) null, filter, update, updateOptions, false);
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateOne(ClientSession clientSession, Bson filter, Bson update) {
        return updateOne(clientSession, filter, update, new UpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateOne(ClientSession clientSession, Bson filter, Bson update, UpdateOptions updateOptions) {
        Assertions.notNull("clientSession", clientSession);
        return executeUpdate(clientSession, filter, update, updateOptions, false);
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateOne(Bson filter, List<? extends Bson> update) {
        return updateOne(filter, update, new UpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateOne(Bson filter, List<? extends Bson> update, UpdateOptions updateOptions) {
        return executeUpdate((ClientSession) null, filter, update, updateOptions, false);
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateOne(ClientSession clientSession, Bson filter, List<? extends Bson> update) {
        return updateOne(clientSession, filter, update, new UpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateOne(ClientSession clientSession, Bson filter, List<? extends Bson> update, UpdateOptions updateOptions) {
        Assertions.notNull("clientSession", clientSession);
        return executeUpdate(clientSession, filter, update, updateOptions, false);
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateMany(Bson filter, Bson update) {
        return updateMany(filter, update, new UpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateMany(Bson filter, Bson update, UpdateOptions updateOptions) {
        return executeUpdate((ClientSession) null, filter, update, updateOptions, true);
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateMany(ClientSession clientSession, Bson filter, Bson update) {
        return updateMany(clientSession, filter, update, new UpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateMany(ClientSession clientSession, Bson filter, Bson update, UpdateOptions updateOptions) {
        Assertions.notNull("clientSession", clientSession);
        return executeUpdate(clientSession, filter, update, updateOptions, true);
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateMany(Bson filter, List<? extends Bson> update) {
        return updateMany(filter, update, new UpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateMany(Bson filter, List<? extends Bson> update, UpdateOptions updateOptions) {
        return executeUpdate((ClientSession) null, filter, update, updateOptions, true);
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateMany(ClientSession clientSession, Bson filter, List<? extends Bson> update) {
        return updateMany(clientSession, filter, update, new UpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public UpdateResult updateMany(ClientSession clientSession, Bson filter, List<? extends Bson> update, UpdateOptions updateOptions) {
        Assertions.notNull("clientSession", clientSession);
        return executeUpdate(clientSession, filter, update, updateOptions, true);
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndDelete(Bson filter) {
        return findOneAndDelete(filter, new FindOneAndDeleteOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndDelete(Bson filter, FindOneAndDeleteOptions options) {
        return executeFindOneAndDelete(null, filter, options);
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndDelete(ClientSession clientSession, Bson filter) {
        return findOneAndDelete(clientSession, filter, new FindOneAndDeleteOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndDelete(ClientSession clientSession, Bson filter, FindOneAndDeleteOptions options) {
        Assertions.notNull("clientSession", clientSession);
        return executeFindOneAndDelete(clientSession, filter, options);
    }

    @Nullable
    private TDocument executeFindOneAndDelete(@Nullable ClientSession clientSession, Bson filter, FindOneAndDeleteOptions options) {
        return (TDocument) this.executor.execute(this.operations.findOneAndDelete(filter, options), this.readConcern, clientSession);
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndReplace(Bson filter, TDocument replacement) {
        return findOneAndReplace(filter, (Bson) replacement, new FindOneAndReplaceOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndReplace(Bson filter, TDocument replacement, FindOneAndReplaceOptions options) {
        return executeFindOneAndReplace(null, filter, replacement, options);
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndReplace(ClientSession clientSession, Bson filter, TDocument replacement) {
        return findOneAndReplace(clientSession, filter, replacement, new FindOneAndReplaceOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndReplace(ClientSession clientSession, Bson filter, TDocument replacement, FindOneAndReplaceOptions options) {
        Assertions.notNull("clientSession", clientSession);
        return executeFindOneAndReplace(clientSession, filter, replacement, options);
    }

    @Nullable
    private TDocument executeFindOneAndReplace(@Nullable ClientSession clientSession, Bson filter, TDocument replacement, FindOneAndReplaceOptions options) {
        return (TDocument) this.executor.execute(this.operations.findOneAndReplace(filter, replacement, options), this.readConcern, clientSession);
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndUpdate(Bson filter, Bson update) {
        return findOneAndUpdate(filter, update, new FindOneAndUpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndUpdate(Bson filter, Bson update, FindOneAndUpdateOptions options) {
        return executeFindOneAndUpdate((ClientSession) null, filter, update, options);
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndUpdate(ClientSession clientSession, Bson filter, Bson update) {
        return findOneAndUpdate(clientSession, filter, update, new FindOneAndUpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndUpdate(ClientSession clientSession, Bson filter, Bson update, FindOneAndUpdateOptions options) {
        Assertions.notNull("clientSession", clientSession);
        return executeFindOneAndUpdate(clientSession, filter, update, options);
    }

    @Nullable
    private TDocument executeFindOneAndUpdate(@Nullable ClientSession clientSession, Bson filter, Bson update, FindOneAndUpdateOptions options) {
        return (TDocument) this.executor.execute(this.operations.findOneAndUpdate(filter, update, options), this.readConcern, clientSession);
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndUpdate(Bson filter, List<? extends Bson> update) {
        return findOneAndUpdate(filter, update, new FindOneAndUpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndUpdate(Bson filter, List<? extends Bson> update, FindOneAndUpdateOptions options) {
        return executeFindOneAndUpdate((ClientSession) null, filter, update, options);
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndUpdate(ClientSession clientSession, Bson filter, List<? extends Bson> update) {
        return findOneAndUpdate(clientSession, filter, update, new FindOneAndUpdateOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    @Nullable
    public TDocument findOneAndUpdate(ClientSession clientSession, Bson filter, List<? extends Bson> update, FindOneAndUpdateOptions options) {
        Assertions.notNull("clientSession", clientSession);
        return executeFindOneAndUpdate(clientSession, filter, update, options);
    }

    @Nullable
    private TDocument executeFindOneAndUpdate(@Nullable ClientSession clientSession, Bson filter, List<? extends Bson> update, FindOneAndUpdateOptions options) {
        return (TDocument) this.executor.execute(this.operations.findOneAndUpdate(filter, update, options), this.readConcern, clientSession);
    }

    @Override // com.mongodb.client.MongoCollection
    public void drop() {
        executeDrop(null);
    }

    @Override // com.mongodb.client.MongoCollection
    public void drop(ClientSession clientSession) {
        Assertions.notNull("clientSession", clientSession);
        executeDrop(clientSession);
    }

    private void executeDrop(@Nullable ClientSession clientSession) {
        this.executor.execute(this.operations.dropCollection(), this.readConcern, clientSession);
    }

    @Override // com.mongodb.client.MongoCollection
    public String createIndex(Bson keys) {
        return createIndex(keys, new IndexOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public String createIndex(Bson keys, IndexOptions indexOptions) {
        return createIndexes(Collections.singletonList(new IndexModel(keys, indexOptions))).get(0);
    }

    @Override // com.mongodb.client.MongoCollection
    public String createIndex(ClientSession clientSession, Bson keys) {
        return createIndex(clientSession, keys, new IndexOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public String createIndex(ClientSession clientSession, Bson keys, IndexOptions indexOptions) {
        return createIndexes(clientSession, Collections.singletonList(new IndexModel(keys, indexOptions))).get(0);
    }

    @Override // com.mongodb.client.MongoCollection
    public List<String> createIndexes(List<IndexModel> indexes) {
        return createIndexes(indexes, new CreateIndexOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public List<String> createIndexes(List<IndexModel> indexes, CreateIndexOptions createIndexOptions) {
        return executeCreateIndexes(null, indexes, createIndexOptions);
    }

    @Override // com.mongodb.client.MongoCollection
    public List<String> createIndexes(ClientSession clientSession, List<IndexModel> indexes) {
        return createIndexes(clientSession, indexes, new CreateIndexOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public List<String> createIndexes(ClientSession clientSession, List<IndexModel> indexes, CreateIndexOptions createIndexOptions) {
        Assertions.notNull("clientSession", clientSession);
        return executeCreateIndexes(clientSession, indexes, createIndexOptions);
    }

    private List<String> executeCreateIndexes(@Nullable ClientSession clientSession, List<IndexModel> indexes, CreateIndexOptions createIndexOptions) {
        this.executor.execute(this.operations.createIndexes(indexes, createIndexOptions), this.readConcern, clientSession);
        return IndexHelper.getIndexNames(indexes, this.codecRegistry);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.mongodb.client.ListIndexesIterable<TResult>, com.mongodb.client.ListIndexesIterable<org.bson.Document> */
    @Override // com.mongodb.client.MongoCollection
    public ListIndexesIterable<Document> listIndexes() {
        return listIndexes(Document.class);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> ListIndexesIterable<TResult> listIndexes(Class<TResult> resultClass) {
        return createListIndexesIterable(null, resultClass);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.mongodb.client.ListIndexesIterable<TResult>, com.mongodb.client.ListIndexesIterable<org.bson.Document> */
    @Override // com.mongodb.client.MongoCollection
    public ListIndexesIterable<Document> listIndexes(ClientSession clientSession) {
        return listIndexes(clientSession, Document.class);
    }

    @Override // com.mongodb.client.MongoCollection
    public <TResult> ListIndexesIterable<TResult> listIndexes(ClientSession clientSession, Class<TResult> resultClass) {
        Assertions.notNull("clientSession", clientSession);
        return createListIndexesIterable(clientSession, resultClass);
    }

    private <TResult> ListIndexesIterable<TResult> createListIndexesIterable(@Nullable ClientSession clientSession, Class<TResult> resultClass) {
        return new ListIndexesIterableImpl(clientSession, getNamespace(), resultClass, this.codecRegistry, ReadPreference.primary(), this.executor, this.retryReads);
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndex(String indexName) {
        dropIndex(indexName, new DropIndexOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndex(String indexName, DropIndexOptions dropIndexOptions) {
        executeDropIndex((ClientSession) null, indexName, dropIndexOptions);
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndex(Bson keys) {
        dropIndex(keys, new DropIndexOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndex(Bson keys, DropIndexOptions dropIndexOptions) {
        executeDropIndex((ClientSession) null, keys, dropIndexOptions);
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndex(ClientSession clientSession, String indexName) {
        dropIndex(clientSession, indexName, new DropIndexOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndex(ClientSession clientSession, Bson keys) {
        dropIndex(clientSession, keys, new DropIndexOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndex(ClientSession clientSession, String indexName, DropIndexOptions dropIndexOptions) {
        Assertions.notNull("clientSession", clientSession);
        executeDropIndex(clientSession, indexName, dropIndexOptions);
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndex(ClientSession clientSession, Bson keys, DropIndexOptions dropIndexOptions) {
        Assertions.notNull("clientSession", clientSession);
        executeDropIndex(clientSession, keys, dropIndexOptions);
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndexes() {
        dropIndex("*");
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndexes(ClientSession clientSession) {
        Assertions.notNull("clientSession", clientSession);
        executeDropIndex(clientSession, "*", new DropIndexOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndexes(DropIndexOptions dropIndexOptions) {
        dropIndex("*", dropIndexOptions);
    }

    @Override // com.mongodb.client.MongoCollection
    public void dropIndexes(ClientSession clientSession, DropIndexOptions dropIndexOptions) {
        dropIndex(clientSession, "*", dropIndexOptions);
    }

    private void executeDropIndex(@Nullable ClientSession clientSession, String indexName, DropIndexOptions dropIndexOptions) {
        Assertions.notNull("dropIndexOptions", dropIndexOptions);
        this.executor.execute(this.operations.dropIndex(indexName, dropIndexOptions), this.readConcern, clientSession);
    }

    private void executeDropIndex(@Nullable ClientSession clientSession, Bson keys, DropIndexOptions dropIndexOptions) {
        this.executor.execute(this.operations.dropIndex(keys, dropIndexOptions), this.readConcern, clientSession);
    }

    @Override // com.mongodb.client.MongoCollection
    public void renameCollection(MongoNamespace newCollectionNamespace) {
        renameCollection(newCollectionNamespace, new RenameCollectionOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public void renameCollection(MongoNamespace newCollectionNamespace, RenameCollectionOptions renameCollectionOptions) {
        executeRenameCollection(null, newCollectionNamespace, renameCollectionOptions);
    }

    @Override // com.mongodb.client.MongoCollection
    public void renameCollection(ClientSession clientSession, MongoNamespace newCollectionNamespace) {
        renameCollection(clientSession, newCollectionNamespace, new RenameCollectionOptions());
    }

    @Override // com.mongodb.client.MongoCollection
    public void renameCollection(ClientSession clientSession, MongoNamespace newCollectionNamespace, RenameCollectionOptions renameCollectionOptions) {
        Assertions.notNull("clientSession", clientSession);
        executeRenameCollection(clientSession, newCollectionNamespace, renameCollectionOptions);
    }

    private void executeRenameCollection(@Nullable ClientSession clientSession, MongoNamespace newCollectionNamespace, RenameCollectionOptions renameCollectionOptions) {
        this.executor.execute(new RenameCollectionOperation(getNamespace(), newCollectionNamespace, this.writeConcern).dropTarget(renameCollectionOptions.isDropTarget()), this.readConcern, clientSession);
    }

    private DeleteResult executeDelete(@Nullable ClientSession clientSession, Bson filter, DeleteOptions deleteOptions, boolean multi) {
        BulkWriteResult result = executeSingleWriteRequest(clientSession, multi ? this.operations.deleteMany(filter, deleteOptions) : this.operations.deleteOne(filter, deleteOptions), WriteRequest.Type.DELETE);
        if (result.wasAcknowledged()) {
            return DeleteResult.acknowledged((long) result.getDeletedCount());
        }
        return DeleteResult.unacknowledged();
    }

    private UpdateResult executeUpdate(@Nullable ClientSession clientSession, Bson filter, Bson update, UpdateOptions updateOptions, boolean multi) {
        return toUpdateResult(executeSingleWriteRequest(clientSession, multi ? this.operations.updateMany(filter, update, updateOptions) : this.operations.updateOne(filter, update, updateOptions), WriteRequest.Type.UPDATE));
    }

    private UpdateResult executeUpdate(@Nullable ClientSession clientSession, Bson filter, List<? extends Bson> update, UpdateOptions updateOptions, boolean multi) {
        return toUpdateResult(executeSingleWriteRequest(clientSession, multi ? this.operations.updateMany(filter, update, updateOptions) : this.operations.updateOne(filter, update, updateOptions), WriteRequest.Type.UPDATE));
    }

    private BulkWriteResult executeSingleWriteRequest(@Nullable ClientSession clientSession, WriteOperation<BulkWriteResult> writeOperation, WriteRequest.Type type) {
        MongoException exception;
        try {
            return (BulkWriteResult) this.executor.execute(writeOperation, this.readConcern, clientSession);
        } catch (MongoBulkWriteException e) {
            if (e.getWriteErrors().isEmpty()) {
                exception = new MongoWriteConcernException(e.getWriteConcernError(), translateBulkWriteResult(type, e.getWriteResult()), e.getServerAddress());
            } else {
                exception = new MongoWriteException(new WriteError(e.getWriteErrors().get(0)), e.getServerAddress());
            }
            for (String errorLabel : e.getErrorLabels()) {
                exception.addLabel(errorLabel);
            }
            throw exception;
        }
    }

    private WriteConcernResult translateBulkWriteResult(WriteRequest.Type type, BulkWriteResult writeResult) {
        switch (type) {
            case INSERT:
                return WriteConcernResult.acknowledged(writeResult.getInsertedCount(), false, null);
            case DELETE:
                return WriteConcernResult.acknowledged(writeResult.getDeletedCount(), false, null);
            case UPDATE:
            case REPLACE:
                return WriteConcernResult.acknowledged(writeResult.getMatchedCount() + writeResult.getUpserts().size(), writeResult.getMatchedCount() > 0, writeResult.getUpserts().isEmpty() ? null : writeResult.getUpserts().get(0).getId());
            default:
                throw new MongoInternalException("Unhandled write request type: " + type);
        }
    }

    private InsertOneResult toInsertOneResult(BulkWriteResult result) {
        if (!result.wasAcknowledged()) {
            return InsertOneResult.unacknowledged();
        }
        return InsertOneResult.acknowledged(result.getInserts().isEmpty() ? null : result.getInserts().get(0).getId());
    }

    private InsertManyResult toInsertManyResult(BulkWriteResult result) {
        if (result.wasAcknowledged()) {
            return InsertManyResult.acknowledged((Map) result.getInserts().stream().collect(HashMap::new, m, v -> {
                m.put(Integer.valueOf(v.getIndex()), v.getId());
            }, (v0, v1) -> {
                v0.putAll(v1);
            }));
        }
        return InsertManyResult.unacknowledged();
    }

    private UpdateResult toUpdateResult(BulkWriteResult result) {
        if (!result.wasAcknowledged()) {
            return UpdateResult.unacknowledged();
        }
        return UpdateResult.acknowledged((long) result.getMatchedCount(), Long.valueOf((long) result.getModifiedCount()), result.getUpserts().isEmpty() ? null : result.getUpserts().get(0).getId());
    }
}
