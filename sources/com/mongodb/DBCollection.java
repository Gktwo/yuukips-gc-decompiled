package com.mongodb;

import com.mongodb.MapReduceCommand;
import com.mongodb.annotations.ThreadSafe;
import com.mongodb.assertions.Assertions;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.internal.MongoBatchCursorAdapter;
import com.mongodb.client.internal.MongoIterableImpl;
import com.mongodb.client.internal.OperationExecutor;
import com.mongodb.client.model.DBCollectionCountOptions;
import com.mongodb.client.model.DBCollectionDistinctOptions;
import com.mongodb.client.model.DBCollectionFindAndModifyOptions;
import com.mongodb.client.model.DBCollectionFindOptions;
import com.mongodb.client.model.DBCollectionRemoveOptions;
import com.mongodb.client.model.DBCollectionUpdateOptions;
import com.mongodb.connection.BufferProvider;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.IndexRequest;
import com.mongodb.internal.bulk.InsertRequest;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.bulk.WriteRequest;
import com.mongodb.internal.operation.AggregateOperation;
import com.mongodb.internal.operation.AggregateToCollectionOperation;
import com.mongodb.internal.operation.BaseWriteOperation;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.CountOperation;
import com.mongodb.internal.operation.CreateIndexesOperation;
import com.mongodb.internal.operation.DeleteOperation;
import com.mongodb.internal.operation.DistinctOperation;
import com.mongodb.internal.operation.DropCollectionOperation;
import com.mongodb.internal.operation.DropIndexOperation;
import com.mongodb.internal.operation.FindAndDeleteOperation;
import com.mongodb.internal.operation.FindAndReplaceOperation;
import com.mongodb.internal.operation.FindAndUpdateOperation;
import com.mongodb.internal.operation.InsertOperation;
import com.mongodb.internal.operation.ListIndexesOperation;
import com.mongodb.internal.operation.MapReduceBatchCursor;
import com.mongodb.internal.operation.MapReduceStatistics;
import com.mongodb.internal.operation.MapReduceToCollectionOperation;
import com.mongodb.internal.operation.MapReduceWithInlineResultsOperation;
import com.mongodb.internal.operation.MixedBulkWriteOperation;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.internal.operation.RenameCollectionOperation;
import com.mongodb.internal.operation.UpdateOperation;
import com.mongodb.internal.operation.WriteOperation;
import com.mongodb.lang.Nullable;
import dev.morphia.mapping.Mapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonDocumentReader;
import org.bson.BsonDocumentWrapper;
import org.bson.BsonInt32;
import org.bson.BsonJavaScript;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.BsonValueCodec;
import org.bson.codecs.Codec;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.Encoder;
import org.bson.types.ObjectId;
import p001ch.qos.logback.core.pattern.parser.Parser;

@ThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/DBCollection.class */
public class DBCollection {
    public static final String ID_FIELD_NAME = "_id";
    private final String name;
    private final C0961DB database;
    private final OperationExecutor executor;
    private final boolean retryWrites;
    private final boolean retryReads;
    private volatile ReadPreference readPreference;
    private volatile WriteConcern writeConcern;
    private volatile ReadConcern readConcern;
    private DBEncoderFactory encoderFactory;
    private DBDecoderFactory decoderFactory;
    private DBCollectionObjectFactory objectFactory;
    private volatile CompoundDBObjectCodec objectCodec;

    /* access modifiers changed from: package-private */
    public DBCollection(String name, C0961DB database, OperationExecutor executor) {
        MongoNamespace.checkCollectionNameValidity(name);
        this.name = name;
        this.database = database;
        this.executor = executor;
        this.objectFactory = new DBCollectionObjectFactory();
        this.objectCodec = new CompoundDBObjectCodec(getDefaultDBObjectCodec());
        this.retryWrites = database.getMongoClient().getMongoClientOptions().getRetryWrites();
        this.retryReads = database.getMongoClient().getMongoClientOptions().getRetryReads();
    }

    protected DBCollection(C0961DB database, String name) {
        this(name, database, database.getExecutor());
    }

    public WriteResult insert(DBObject document, WriteConcern writeConcern) {
        return insert(Arrays.asList(document), writeConcern);
    }

    public WriteResult insert(DBObject... documents) {
        return insert(Arrays.asList(documents), getWriteConcern());
    }

    public WriteResult insert(WriteConcern writeConcern, DBObject... documents) {
        return insert(documents, writeConcern);
    }

    public WriteResult insert(DBObject[] documents, WriteConcern writeConcern) {
        return insert(Arrays.asList(documents), writeConcern);
    }

    public WriteResult insert(List<? extends DBObject> documents) {
        return insert(documents, getWriteConcern());
    }

    public WriteResult insert(List<? extends DBObject> documents, WriteConcern aWriteConcern) {
        return insert(documents, aWriteConcern, (DBEncoder) null);
    }

    public WriteResult insert(DBObject[] documents, WriteConcern aWriteConcern, DBEncoder encoder) {
        return insert(Arrays.asList(documents), aWriteConcern, encoder);
    }

    public WriteResult insert(List<? extends DBObject> documents, WriteConcern aWriteConcern, @Nullable DBEncoder dbEncoder) {
        return insert(documents, new InsertOptions().writeConcern(aWriteConcern).dbEncoder(dbEncoder));
    }

    public WriteResult insert(List<? extends DBObject> documents, InsertOptions insertOptions) {
        WriteConcern writeConcern = insertOptions.getWriteConcern() != null ? insertOptions.getWriteConcern() : getWriteConcern();
        Encoder<DBObject> encoder = toEncoder(insertOptions.getDbEncoder());
        List<InsertRequest> insertRequestList = new ArrayList<>(documents.size());
        for (DBObject cur : documents) {
            if (cur.get(ID_FIELD_NAME) == null) {
                cur.put(ID_FIELD_NAME, new ObjectId());
            }
            insertRequestList.add(new InsertRequest(new BsonDocumentWrapper(cur, encoder)));
        }
        return insert(insertRequestList, writeConcern, insertOptions.isContinueOnError(), insertOptions.getBypassDocumentValidation());
    }

    private Encoder<DBObject> toEncoder(@Nullable DBEncoder dbEncoder) {
        return dbEncoder != null ? new DBEncoderAdapter(dbEncoder) : this.objectCodec;
    }

    private WriteResult insert(List<InsertRequest> insertRequestList, WriteConcern writeConcern, boolean continueOnError, @Nullable Boolean bypassDocumentValidation) {
        return executeWriteOperation(new InsertOperation(getNamespace(), !continueOnError, writeConcern, this.retryWrites, insertRequestList).bypassDocumentValidation(bypassDocumentValidation));
    }

    WriteResult executeWriteOperation(BaseWriteOperation operation) {
        return translateWriteResult((WriteConcernResult) this.executor.execute(operation, getReadConcern()));
    }

    private WriteResult translateWriteResult(WriteConcernResult writeConcernResult) {
        if (!writeConcernResult.wasAcknowledged()) {
            return WriteResult.unacknowledged();
        }
        return translateWriteResult(writeConcernResult.getCount(), writeConcernResult.isUpdateOfExisting(), writeConcernResult.getUpsertedId());
    }

    private WriteResult translateWriteResult(int count, boolean isUpdateOfExisting, @Nullable BsonValue upsertedId) {
        Object newUpsertedId;
        if (upsertedId == null) {
            newUpsertedId = null;
        } else {
            newUpsertedId = getObjectCodec().decode(new BsonDocumentReader(new BsonDocument(ID_FIELD_NAME, upsertedId)), DecoderContext.builder().build()).get(ID_FIELD_NAME);
        }
        return new WriteResult(count, isUpdateOfExisting, newUpsertedId);
    }

    public WriteResult save(DBObject document) {
        return save(document, getWriteConcern());
    }

    public WriteResult save(DBObject document, WriteConcern writeConcern) {
        Object id = document.get(ID_FIELD_NAME);
        if (id == null) {
            return insert(document, writeConcern);
        }
        return replaceOrInsert(document, id, writeConcern);
    }

    private WriteResult replaceOrInsert(DBObject obj, Object id, WriteConcern writeConcern) {
        return executeWriteOperation(new UpdateOperation(getNamespace(), false, writeConcern, this.retryWrites, Collections.singletonList(new UpdateRequest(wrap(new BasicDBObject(ID_FIELD_NAME, id)), wrap(obj, this.objectCodec), WriteRequest.Type.REPLACE).upsert(true))));
    }

    public WriteResult update(DBObject query, DBObject update, boolean upsert, boolean multi, WriteConcern aWriteConcern) {
        return update(query, update, upsert, multi, aWriteConcern, null);
    }

    public WriteResult update(DBObject query, DBObject update, boolean upsert, boolean multi, WriteConcern concern, @Nullable DBEncoder encoder) {
        return update(query, update, upsert, multi, concern, null, encoder);
    }

    public WriteResult update(DBObject query, DBObject update, boolean upsert, boolean multi, WriteConcern concern, @Nullable Boolean bypassDocumentValidation, @Nullable DBEncoder encoder) {
        return update(query, update, new DBCollectionUpdateOptions().upsert(upsert).multi(multi).writeConcern(concern).bypassDocumentValidation(bypassDocumentValidation).encoder(encoder));
    }

    public WriteResult update(DBObject query, DBObject update, boolean upsert, boolean multi) {
        return update(query, update, upsert, multi, getWriteConcern());
    }

    public WriteResult update(DBObject query, DBObject update) {
        return update(query, update, false, false);
    }

    public WriteResult updateMulti(DBObject query, DBObject update) {
        return update(query, update, false, true);
    }

    public WriteResult update(DBObject query, DBObject update, DBCollectionUpdateOptions options) {
        Assertions.notNull("query", query);
        Assertions.notNull("update", update);
        Assertions.notNull("options", options);
        return executeWriteOperation(new UpdateOperation(getNamespace(), true, options.getWriteConcern() != null ? options.getWriteConcern() : getWriteConcern(), this.retryWrites, Collections.singletonList(new UpdateRequest(wrap(query), wrap(update, options.getEncoder()), (update.keySet().isEmpty() || !update.keySet().iterator().next().startsWith("$")) ? WriteRequest.Type.REPLACE : WriteRequest.Type.UPDATE).upsert(options.isUpsert()).multi(options.isMulti()).collation(options.getCollation()).arrayFilters(wrapAllowNull(options.getArrayFilters(), options.getEncoder())))).bypassDocumentValidation(options.getBypassDocumentValidation()));
    }

    public WriteResult remove(DBObject query) {
        return remove(query, getWriteConcern());
    }

    public WriteResult remove(DBObject query, WriteConcern writeConcern) {
        return remove(query, new DBCollectionRemoveOptions().writeConcern(writeConcern));
    }

    public WriteResult remove(DBObject query, WriteConcern writeConcern, DBEncoder encoder) {
        return remove(query, new DBCollectionRemoveOptions().writeConcern(writeConcern).encoder(encoder));
    }

    public WriteResult remove(DBObject query, DBCollectionRemoveOptions options) {
        Assertions.notNull("query", query);
        Assertions.notNull("options", options);
        return executeWriteOperation(new DeleteOperation(getNamespace(), false, options.getWriteConcern() != null ? options.getWriteConcern() : getWriteConcern(), this.retryWrites, Collections.singletonList(new DeleteRequest(wrap(query, options.getEncoder())).collation(options.getCollation()))));
    }

    public DBCursor find(DBObject query) {
        return new DBCursor(this, query, (DBObject) null, getReadPreference());
    }

    public DBCursor find(DBObject query, DBObject projection) {
        return new DBCursor(this, query, projection, getReadPreference());
    }

    public DBCursor find() {
        return find(new BasicDBObject());
    }

    public DBCursor find(@Nullable DBObject query, DBCollectionFindOptions options) {
        return new DBCursor(this, query, options);
    }

    @Nullable
    public DBObject findOne() {
        return findOne((DBObject) new BasicDBObject());
    }

    @Nullable
    public DBObject findOne(DBObject query) {
        return findOne(query, null, null, getReadPreference());
    }

    @Nullable
    public DBObject findOne(DBObject query, DBObject projection) {
        return findOne(query, projection, null, getReadPreference());
    }

    @Nullable
    public DBObject findOne(DBObject query, DBObject projection, DBObject sort) {
        return findOne(query, projection, sort, getReadPreference());
    }

    @Nullable
    public DBObject findOne(DBObject query, DBObject projection, ReadPreference readPreference) {
        return findOne(query, projection, null, readPreference);
    }

    @Nullable
    public DBObject findOne(@Nullable DBObject query, @Nullable DBObject projection, @Nullable DBObject sort, ReadPreference readPreference) {
        return findOne(query != null ? query : new BasicDBObject(), new DBCollectionFindOptions().projection(projection).sort(sort).readPreference(readPreference));
    }

    @Nullable
    public DBObject findOne(Object id) {
        return findOne(new BasicDBObject(ID_FIELD_NAME, id), new DBCollectionFindOptions());
    }

    @Nullable
    public DBObject findOne(Object id, DBObject projection) {
        return findOne(new BasicDBObject(ID_FIELD_NAME, id), new DBCollectionFindOptions().projection(projection));
    }

    @Nullable
    public DBObject findOne(@Nullable DBObject query, DBCollectionFindOptions findOptions) {
        return find(query, findOptions).one();
    }

    public long count() {
        return getCount(new BasicDBObject(), new DBCollectionCountOptions());
    }

    public long count(@Nullable DBObject query) {
        return getCount(query, new DBCollectionCountOptions());
    }

    public long count(@Nullable DBObject query, ReadPreference readPreference) {
        return getCount(query, new DBCollectionCountOptions().readPreference(readPreference));
    }

    public long count(@Nullable DBObject query, DBCollectionCountOptions options) {
        return getCount(query, options);
    }

    public long getCount() {
        return getCount(new BasicDBObject(), new DBCollectionCountOptions());
    }

    public long getCount(@Nullable DBObject query) {
        return getCount(query, new DBCollectionCountOptions());
    }

    public long getCount(@Nullable DBObject query, DBCollectionCountOptions options) {
        Assertions.notNull("countOptions", options);
        CountOperation operation = new CountOperation(getNamespace()).skip((long) options.getSkip()).limit((long) options.getLimit()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).collation(options.getCollation()).retryReads(this.retryReads);
        if (query != null) {
            operation.filter(wrap(query));
        }
        DBObject hint = options.getHint();
        if (hint != null) {
            operation.hint(wrap(hint));
        } else {
            String hintString = options.getHintString();
            if (hintString != null) {
                operation.hint(new BsonString(hintString));
            }
        }
        ReadPreference optionsReadPreference = options.getReadPreference();
        ReadConcern optionsReadConcern = options.getReadConcern();
        return ((Long) this.executor.execute(operation, optionsReadPreference != null ? optionsReadPreference : getReadPreference(), optionsReadConcern != null ? optionsReadConcern : getReadConcern())).longValue();
    }

    public DBCollection rename(String newName) {
        return rename(newName, false);
    }

    public DBCollection rename(String newName, boolean dropTarget) {
        try {
            this.executor.execute(new RenameCollectionOperation(getNamespace(), new MongoNamespace(getNamespace().getDatabaseName(), newName), getWriteConcern()).dropTarget(dropTarget), getReadConcern());
            return getDB().getCollection(newName);
        } catch (MongoWriteConcernException e) {
            throw createWriteConcernException(e);
        }
    }

    public List distinct(String fieldName) {
        return distinct(fieldName, getReadPreference());
    }

    public List distinct(String fieldName, ReadPreference readPreference) {
        return distinct(fieldName, new BasicDBObject(), readPreference);
    }

    public List distinct(String fieldName, DBObject query) {
        return distinct(fieldName, query, getReadPreference());
    }

    public List distinct(String fieldName, DBObject query, ReadPreference readPreference) {
        return distinct(fieldName, new DBCollectionDistinctOptions().filter(query).readPreference(readPreference));
    }

    public List distinct(final String fieldName, final DBCollectionDistinctOptions options) {
        Assertions.notNull("fieldName", fieldName);
        return (List) new MongoIterableImpl<BsonValue>(null, this.executor, options.getReadConcern() != null ? options.getReadConcern() : getReadConcern(), options.getReadPreference() != null ? options.getReadPreference() : getReadPreference(), this.retryReads) { // from class: com.mongodb.DBCollection.2
            @Override // com.mongodb.client.internal.MongoIterableImpl
            public ReadOperation<BatchCursor<BsonValue>> asReadOperation() {
                return new DistinctOperation(DBCollection.this.getNamespace(), fieldName, new BsonValueCodec()).filter(DBCollection.this.wrapAllowNull(options.getFilter())).collation(options.getCollation()).retryReads(DBCollection.this.retryReads);
            }
        }.map(new Function<BsonValue, Object>() { // from class: com.mongodb.DBCollection.1
            public Object apply(BsonValue bsonValue) {
                if (bsonValue == null) {
                    return null;
                }
                return DBCollection.this.getDefaultDBObjectCodec().decode(new BsonDocumentReader(new BsonDocument("value", bsonValue)), DecoderContext.builder().build()).get("value");
            }
        }).into(new ArrayList());
    }

    public MapReduceOutput mapReduce(String map, String reduce, String outputTarget, DBObject query) {
        return mapReduce(new MapReduceCommand(this, map, reduce, outputTarget, MapReduceCommand.OutputType.REDUCE, query));
    }

    public MapReduceOutput mapReduce(String map, String reduce, String outputTarget, MapReduceCommand.OutputType outputType, DBObject query) {
        return mapReduce(new MapReduceCommand(this, map, reduce, outputTarget, outputType, query));
    }

    public MapReduceOutput mapReduce(String map, String reduce, String outputTarget, MapReduceCommand.OutputType outputType, DBObject query, ReadPreference readPreference) {
        MapReduceCommand command = new MapReduceCommand(this, map, reduce, outputTarget, outputType, query);
        command.setReadPreference(readPreference);
        return mapReduce(command);
    }

    public MapReduceOutput mapReduce(MapReduceCommand command) {
        String action;
        ReadPreference readPreference = command.getReadPreference() == null ? getReadPreference() : command.getReadPreference();
        Map<String, Object> scope = command.getScope();
        Boolean jsMode = command.getJsMode();
        if (command.getOutputType() == MapReduceCommand.OutputType.INLINE) {
            MapReduceWithInlineResultsOperation<DBObject> operation = new MapReduceWithInlineResultsOperation(getNamespace(), new BsonJavaScript(command.getMap()), new BsonJavaScript(command.getReduce()), getDefaultDBObjectCodec()).filter(wrapAllowNull(command.getQuery())).limit(command.getLimit()).maxTime(command.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).jsMode(jsMode == null ? false : jsMode.booleanValue()).sort(wrapAllowNull(command.getSort())).verbose(command.isVerbose().booleanValue()).collation(command.getCollation());
            if (scope != null) {
                operation.scope(wrap(new BasicDBObject(scope)));
            }
            if (command.getFinalize() != null) {
                operation.finalizeFunction(new BsonJavaScript(command.getFinalize()));
            }
            return new MapReduceOutput(command.toDBObject(), (MapReduceBatchCursor) this.executor.execute(operation, readPreference, getReadConcern()));
        }
        switch (command.getOutputType()) {
            case REPLACE:
                action = Parser.REPLACE_CONVERTER_WORD;
                break;
            case MERGE:
                action = "merge";
                break;
            case REDUCE:
                action = "reduce";
                break;
            default:
                throw new IllegalArgumentException("Unexpected output type");
        }
        MapReduceToCollectionOperation operation2 = new MapReduceToCollectionOperation(getNamespace(), new BsonJavaScript(command.getMap()), new BsonJavaScript(command.getReduce()), command.getOutputTarget(), getWriteConcern()).filter(wrapAllowNull(command.getQuery())).limit(command.getLimit()).maxTime(command.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).jsMode(jsMode == null ? false : jsMode.booleanValue()).sort(wrapAllowNull(command.getSort())).verbose(command.isVerbose().booleanValue()).action(action).databaseName(command.getOutputDB()).bypassDocumentValidation(command.getBypassDocumentValidation()).collation(command.getCollation());
        if (scope != null) {
            operation2.scope(wrap(new BasicDBObject(scope)));
        }
        if (command.getFinalize() != null) {
            operation2.finalizeFunction(new BsonJavaScript(command.getFinalize()));
        }
        try {
            MapReduceStatistics mapReduceStatistics = (MapReduceStatistics) this.executor.execute(operation2, getReadConcern());
            DBCollection mapReduceOutputCollection = getMapReduceOutputCollection(command);
            return new MapReduceOutput(command.toDBObject(), mapReduceOutputCollection.find(), mapReduceStatistics, mapReduceOutputCollection);
        } catch (MongoWriteConcernException e) {
            throw createWriteConcernException(e);
        }
    }

    private DBCollection getMapReduceOutputCollection(MapReduceCommand command) {
        C0961DB database;
        String requestedDatabaseName = command.getOutputDB();
        if (requestedDatabaseName != null) {
            database = getDB().getSisterDB(requestedDatabaseName);
        } else {
            database = getDB();
        }
        return database.getCollection(command.getOutputTargetNonNull());
    }

    public Cursor aggregate(List<? extends DBObject> pipeline, AggregationOptions options) {
        return aggregate(pipeline, options, getReadPreference());
    }

    public Cursor aggregate(List<? extends DBObject> pipeline, AggregationOptions options, ReadPreference readPreference) {
        Cursor result;
        Assertions.notNull("options", options);
        List<BsonDocument> stages = preparePipeline(pipeline);
        BsonValue outCollection = stages.get(stages.size() - 1).get((Object) "$out");
        if (outCollection != null) {
            try {
                this.executor.execute(new AggregateToCollectionOperation(getNamespace(), stages, getReadConcern(), getWriteConcern()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).allowDiskUse(options.getAllowDiskUse()).bypassDocumentValidation(options.getBypassDocumentValidation()).collation(options.getCollation()), getReadConcern());
                result = new DBCursor(this.database.getCollection(outCollection.asString().getValue()), new BasicDBObject(), new DBCollectionFindOptions().readPreference(ReadPreference.primary()).collation(options.getCollation()));
            } catch (MongoWriteConcernException e) {
                throw createWriteConcernException(e);
            }
        } else {
            result = new MongoCursorAdapter(new MongoBatchCursorAdapter((BatchCursor) this.executor.execute(new AggregateOperation(getNamespace(), stages, getDefaultDBObjectCodec()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).allowDiskUse(options.getAllowDiskUse()).batchSize(options.getBatchSize()).collation(options.getCollation()).retryReads(this.retryReads), readPreference, getReadConcern())));
        }
        return result;
    }

    public CommandResult explainAggregate(List<? extends DBObject> pipeline, AggregationOptions options) {
        return new CommandResult((BsonDocument) this.executor.execute(new AggregateOperation(getNamespace(), preparePipeline(pipeline), new BsonDocumentCodec()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).allowDiskUse(options.getAllowDiskUse()).collation(options.getCollation()).retryReads(this.retryReads).asExplainableOperation(ExplainVerbosity.QUERY_PLANNER, new BsonDocumentCodec()), ReadPreference.primaryPreferred(), getReadConcern()));
    }

    /* access modifiers changed from: package-private */
    public List<BsonDocument> preparePipeline(List<? extends DBObject> pipeline) {
        List<BsonDocument> stages = new ArrayList<>();
        for (DBObject op : pipeline) {
            stages.add(wrap(op));
        }
        return stages;
    }

    public String getName() {
        return this.name;
    }

    public String getFullName() {
        return getNamespace().getFullName();
    }

    public DBCollection getCollection(String name) {
        return this.database.getCollection(getName() + Mapper.IGNORED_FIELDNAME + name);
    }

    public void createIndex(String name) {
        createIndex(new BasicDBObject(name, 1));
    }

    public void createIndex(DBObject keys, String name) {
        createIndex(keys, name, false);
    }

    public void createIndex(DBObject keys, @Nullable String name, boolean unique) {
        DBObject options = new BasicDBObject();
        if (name != null && name.length() > 0) {
            options.put("name", name);
        }
        if (unique) {
            options.put("unique", Boolean.TRUE);
        }
        createIndex(keys, options);
    }

    public void createIndex(DBObject keys) {
        createIndex(keys, new BasicDBObject());
    }

    public void createIndex(DBObject keys, DBObject options) {
        try {
            this.executor.execute(createIndexOperation(keys, options), getReadConcern());
        } catch (MongoWriteConcernException e) {
            throw createWriteConcernException(e);
        }
    }

    @Nullable
    public DBObject findAndModify(@Nullable DBObject query, @Nullable DBObject sort, DBObject update) {
        return findAndModify(query, null, sort, false, update, false, false);
    }

    @Nullable
    public DBObject findAndModify(@Nullable DBObject query, DBObject update) {
        return findAndModify(query, null, null, false, update, false, false);
    }

    @Nullable
    public DBObject findAndRemove(@Nullable DBObject query) {
        return findAndModify(query, null, null, true, null, false, false);
    }

    @Nullable
    public DBObject findAndModify(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, boolean remove, @Nullable DBObject update, boolean returnNew, boolean upsert) {
        return findAndModify(query, fields, sort, remove, update, returnNew, upsert, 0, TimeUnit.MILLISECONDS);
    }

    @Nullable
    public DBObject findAndModify(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, boolean remove, DBObject update, boolean returnNew, boolean upsert, WriteConcern writeConcern) {
        return findAndModify(query, fields, sort, remove, update, returnNew, upsert, 0, TimeUnit.MILLISECONDS, writeConcern);
    }

    @Nullable
    public DBObject findAndModify(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, boolean remove, @Nullable DBObject update, boolean returnNew, boolean upsert, long maxTime, TimeUnit maxTimeUnit) {
        return findAndModify(query, fields, sort, remove, update, returnNew, upsert, maxTime, maxTimeUnit, getWriteConcern());
    }

    @Nullable
    public DBObject findAndModify(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, boolean remove, @Nullable DBObject update, boolean returnNew, boolean upsert, long maxTime, TimeUnit maxTimeUnit, WriteConcern writeConcern) {
        return findAndModify(query != null ? query : new BasicDBObject(), new DBCollectionFindAndModifyOptions().projection(fields).sort(sort).remove(remove).update(update).returnNew(returnNew).upsert(upsert).maxTime(maxTime, maxTimeUnit).writeConcern(writeConcern));
    }

    @Nullable
    public DBObject findAndModify(DBObject query, DBObject fields, DBObject sort, boolean remove, @Nullable DBObject update, boolean returnNew, boolean upsert, boolean bypassDocumentValidation, long maxTime, TimeUnit maxTimeUnit) {
        return findAndModify(query, fields, sort, remove, update, returnNew, upsert, bypassDocumentValidation, maxTime, maxTimeUnit, getWriteConcern());
    }

    public DBObject findAndModify(@Nullable DBObject query, @Nullable DBObject fields, @Nullable DBObject sort, boolean remove, @Nullable DBObject update, boolean returnNew, boolean upsert, boolean bypassDocumentValidation, long maxTime, TimeUnit maxTimeUnit, WriteConcern writeConcern) {
        return findAndModify(query != null ? query : new BasicDBObject(), new DBCollectionFindAndModifyOptions().projection(fields).sort(sort).remove(remove).update(update).returnNew(returnNew).upsert(upsert).bypassDocumentValidation(Boolean.valueOf(bypassDocumentValidation)).maxTime(maxTime, maxTimeUnit).writeConcern(writeConcern));
    }

    public DBObject findAndModify(DBObject query, DBCollectionFindAndModifyOptions options) {
        WriteOperation<DBObject> operation;
        Assertions.notNull("query", query);
        Assertions.notNull("options", options);
        WriteConcern optionsWriteConcern = options.getWriteConcern();
        WriteConcern writeConcern = optionsWriteConcern != null ? optionsWriteConcern : getWriteConcern();
        if (options.isRemove()) {
            operation = new FindAndDeleteOperation(getNamespace(), writeConcern, this.retryWrites, this.objectCodec).filter(wrapAllowNull(query)).projection(wrapAllowNull(options.getProjection())).sort(wrapAllowNull(options.getSort())).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).collation(options.getCollation());
        } else {
            DBObject update = options.getUpdate();
            if (update == null) {
                throw new IllegalArgumentException("update can not be null unless it's a remove");
            } else if (update.keySet().isEmpty() || update.keySet().iterator().next().charAt(0) != '$') {
                operation = new FindAndReplaceOperation(getNamespace(), writeConcern, this.retryWrites, this.objectCodec, wrap(update)).filter(wrap(query)).projection(wrapAllowNull(options.getProjection())).sort(wrapAllowNull(options.getSort())).returnOriginal(!options.returnNew()).upsert(options.isUpsert()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).bypassDocumentValidation(options.getBypassDocumentValidation()).collation(options.getCollation());
            } else {
                operation = new FindAndUpdateOperation(getNamespace(), writeConcern, this.retryWrites, this.objectCodec, wrap(update)).filter(wrap(query)).projection(wrapAllowNull(options.getProjection())).sort(wrapAllowNull(options.getSort())).returnOriginal(!options.returnNew()).upsert(options.isUpsert()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).bypassDocumentValidation(options.getBypassDocumentValidation()).collation(options.getCollation()).arrayFilters(wrapAllowNull(options.getArrayFilters(), (Encoder<DBObject>) null));
            }
        }
        try {
            return (DBObject) this.executor.execute(operation, getReadConcern());
        } catch (MongoWriteConcernException e) {
            throw createWriteConcernException(e);
        }
    }

    public C0961DB getDB() {
        return this.database;
    }

    public WriteConcern getWriteConcern() {
        if (this.writeConcern != null) {
            return this.writeConcern;
        }
        return this.database.getWriteConcern();
    }

    public void setWriteConcern(WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
    }

    public ReadPreference getReadPreference() {
        if (this.readPreference != null) {
            return this.readPreference;
        }
        return this.database.getReadPreference();
    }

    public void setReadPreference(ReadPreference preference) {
        this.readPreference = preference;
    }

    public void setReadConcern(ReadConcern readConcern) {
        this.readConcern = readConcern;
    }

    public ReadConcern getReadConcern() {
        if (this.readConcern != null) {
            return this.readConcern;
        }
        return this.database.getReadConcern();
    }

    public void drop() {
        try {
            this.executor.execute(new DropCollectionOperation(getNamespace(), getWriteConcern()), getReadConcern());
        } catch (MongoWriteConcernException e) {
            throw createWriteConcernException(e);
        }
    }

    public synchronized DBDecoderFactory getDBDecoderFactory() {
        return this.decoderFactory;
    }

    public synchronized void setDBDecoderFactory(@Nullable DBDecoderFactory factory) {
        Decoder<DBObject> decoder;
        this.decoderFactory = factory;
        if (factory == null || factory == DefaultDBDecoder.FACTORY) {
            decoder = getDefaultDBObjectCodec();
        } else {
            decoder = new DBDecoderAdapter(factory.create(), this, getBufferPool());
        }
        this.objectCodec = new CompoundDBObjectCodec(this.objectCodec.getEncoder(), decoder);
    }

    public synchronized DBEncoderFactory getDBEncoderFactory() {
        return this.encoderFactory;
    }

    public synchronized void setDBEncoderFactory(@Nullable DBEncoderFactory factory) {
        Encoder<DBObject> encoder;
        this.encoderFactory = factory;
        if (factory == null || factory == DefaultDBEncoder.FACTORY) {
            encoder = getDefaultDBObjectCodec();
        } else {
            encoder = new DBEncoderFactoryAdapter(this.encoderFactory);
        }
        this.objectCodec = new CompoundDBObjectCodec(encoder, this.objectCodec.getDecoder());
    }

    public List<DBObject> getIndexInfo() {
        return (List) new MongoIterableImpl<DBObject>(null, this.executor, ReadConcern.DEFAULT, ReadPreference.primary(), this.retryReads) { // from class: com.mongodb.DBCollection.3
            @Override // com.mongodb.client.internal.MongoIterableImpl
            public ReadOperation<BatchCursor<DBObject>> asReadOperation() {
                return new ListIndexesOperation(DBCollection.this.getNamespace(), DBCollection.this.getDefaultDBObjectCodec()).retryReads(DBCollection.this.retryReads);
            }
        }.into(new ArrayList());
    }

    public void dropIndex(DBObject index) {
        try {
            this.executor.execute(new DropIndexOperation(getNamespace(), wrap(index), getWriteConcern()), getReadConcern());
        } catch (MongoWriteConcernException e) {
            throw createWriteConcernException(e);
        }
    }

    public void dropIndex(String indexName) {
        try {
            this.executor.execute(new DropIndexOperation(getNamespace(), indexName, getWriteConcern()), getReadConcern());
        } catch (MongoWriteConcernException e) {
            throw createWriteConcernException(e);
        }
    }

    public void dropIndexes() {
        dropIndex("*");
    }

    public void dropIndexes(String indexName) {
        dropIndex(indexName);
    }

    public CommandResult getStats() {
        return getDB().executeCommand(new BsonDocument("collStats", new BsonString(getName())), getReadPreference());
    }

    public boolean isCapped() {
        Object cappedField = getStats().get("capped");
        return cappedField != null && (cappedField.equals(1) || cappedField.equals(true));
    }

    public Class getObjectClass() {
        return this.objectFactory.getClassForPath(Collections.emptyList());
    }

    public void setObjectClass(Class<? extends DBObject> aClass) {
        setObjectFactory(this.objectFactory.update(aClass));
    }

    public void setInternalClass(String path, Class<? extends DBObject> aClass) {
        setObjectFactory(this.objectFactory.update(aClass, Arrays.asList(path.split("\\."))));
    }

    public String toString() {
        return "DBCollection{database=" + this.database + ", name='" + this.name + "'}";
    }

    /* access modifiers changed from: package-private */
    public synchronized DBObjectFactory getObjectFactory() {
        return this.objectFactory;
    }

    synchronized void setObjectFactory(DBCollectionObjectFactory factory) {
        this.objectFactory = factory;
        this.objectCodec = new CompoundDBObjectCodec(this.objectCodec.getEncoder(), getDefaultDBObjectCodec());
    }

    public BulkWriteOperation initializeOrderedBulkOperation() {
        return new BulkWriteOperation(true, this);
    }

    public BulkWriteOperation initializeUnorderedBulkOperation() {
        return new BulkWriteOperation(false, this);
    }

    /* access modifiers changed from: package-private */
    public BulkWriteResult executeBulkWriteOperation(boolean ordered, Boolean bypassDocumentValidation, List<WriteRequest> writeRequests) {
        return executeBulkWriteOperation(ordered, bypassDocumentValidation, writeRequests, getWriteConcern());
    }

    /* access modifiers changed from: package-private */
    public BulkWriteResult executeBulkWriteOperation(boolean ordered, Boolean bypassDocumentValidation, List<WriteRequest> writeRequests, WriteConcern writeConcern) {
        try {
            return BulkWriteHelper.translateBulkWriteResult((BulkWriteResult) this.executor.execute(new MixedBulkWriteOperation(getNamespace(), translateWriteRequestsToNew(writeRequests), ordered, writeConcern, false).bypassDocumentValidation(bypassDocumentValidation), getReadConcern()), getObjectCodec());
        } catch (MongoBulkWriteException e) {
            throw BulkWriteHelper.translateBulkWriteException(e, MongoClient.getDefaultCodecRegistry().get(DBObject.class));
        }
    }

    private List<WriteRequest> translateWriteRequestsToNew(List<WriteRequest> writeRequests) {
        List<WriteRequest> retVal = new ArrayList<>(writeRequests.size());
        for (WriteRequest cur : writeRequests) {
            retVal.add(cur.toNew(this));
        }
        return retVal;
    }

    /* access modifiers changed from: package-private */
    public Codec<DBObject> getDefaultDBObjectCodec() {
        return new DBObjectCodec(getDB().getMongoClient().getCodecRegistry(), DBObjectCodec.getDefaultBsonTypeClassMap(), getObjectFactory()).withUuidRepresentation(getDB().getMongoClient().getMongoClientOptions().getUuidRepresentation());
    }

    private <T> T convertOptionsToType(DBObject options, String field, Class<T> clazz) {
        return (T) convertToType(clazz, options.get(field), String.format("'%s' should be of class %s", field, clazz.getSimpleName()));
    }

    private <T> T convertToType(Class<T> clazz, Object value, String errorMessage) {
        Object transformedValue = (T) value;
        if (clazz == Boolean.class) {
            if (value instanceof Boolean) {
                transformedValue = (T) value;
            } else if (value instanceof Number) {
                transformedValue = (T) Boolean.valueOf(((Number) value).doubleValue() != 0.0d);
            }
        } else if (clazz == Double.class) {
            if (value instanceof Number) {
                transformedValue = (T) Double.valueOf(((Number) value).doubleValue());
            }
        } else if (clazz == Integer.class) {
            if (value instanceof Number) {
                transformedValue = (T) Integer.valueOf(((Number) value).intValue());
            }
        } else if (clazz == Long.class && (value instanceof Number)) {
            transformedValue = (T) Long.valueOf(((Number) value).longValue());
        }
        if (clazz.isAssignableFrom(transformedValue.getClass())) {
            return (T) transformedValue;
        }
        throw new IllegalArgumentException(errorMessage);
    }

    private CreateIndexesOperation createIndexOperation(DBObject key, DBObject options) {
        IndexRequest request = new IndexRequest(wrap(key));
        if (options.containsField("name")) {
            request.name((String) convertOptionsToType(options, "name", String.class));
        }
        if (options.containsField("background")) {
            request.background(((Boolean) convertOptionsToType(options, "background", Boolean.class)).booleanValue());
        }
        if (options.containsField("unique")) {
            request.unique(((Boolean) convertOptionsToType(options, "unique", Boolean.class)).booleanValue());
        }
        if (options.containsField("sparse")) {
            request.sparse(((Boolean) convertOptionsToType(options, "sparse", Boolean.class)).booleanValue());
        }
        if (options.containsField("expireAfterSeconds")) {
            request.expireAfter((Long) convertOptionsToType(options, "expireAfterSeconds", Long.class), TimeUnit.SECONDS);
        }
        if (options.containsField("v")) {
            request.version((Integer) convertOptionsToType(options, "v", Integer.class));
        }
        if (options.containsField("weights")) {
            request.weights(wrap((DBObject) convertOptionsToType(options, "weights", DBObject.class)));
        }
        if (options.containsField("default_language")) {
            request.defaultLanguage((String) convertOptionsToType(options, "default_language", String.class));
        }
        if (options.containsField("language_override")) {
            request.languageOverride((String) convertOptionsToType(options, "language_override", String.class));
        }
        if (options.containsField("textIndexVersion")) {
            request.textVersion((Integer) convertOptionsToType(options, "textIndexVersion", Integer.class));
        }
        if (options.containsField("2dsphereIndexVersion")) {
            request.sphereVersion((Integer) convertOptionsToType(options, "2dsphereIndexVersion", Integer.class));
        }
        if (options.containsField("bits")) {
            request.bits((Integer) convertOptionsToType(options, "bits", Integer.class));
        }
        if (options.containsField("min")) {
            request.min((Double) convertOptionsToType(options, "min", Double.class));
        }
        if (options.containsField("max")) {
            request.max((Double) convertOptionsToType(options, "max", Double.class));
        }
        if (options.containsField("bucketSize")) {
            request.bucketSize((Double) convertOptionsToType(options, "bucketSize", Double.class));
        }
        if (options.containsField("dropDups")) {
            request.dropDups(((Boolean) convertOptionsToType(options, "dropDups", Boolean.class)).booleanValue());
        }
        if (options.containsField("storageEngine")) {
            request.storageEngine(wrap((DBObject) convertOptionsToType(options, "storageEngine", DBObject.class)));
        }
        if (options.containsField("partialFilterExpression")) {
            request.partialFilterExpression(wrap((DBObject) convertOptionsToType(options, "partialFilterExpression", DBObject.class)));
        }
        if (options.containsField("collation")) {
            request.collation(DBObjectCollationHelper.createCollationFromOptions(options));
        }
        return new CreateIndexesOperation(getNamespace(), Collections.singletonList(request), this.writeConcern);
    }

    /* access modifiers changed from: package-private */
    public Codec<DBObject> getObjectCodec() {
        return this.objectCodec;
    }

    /* access modifiers changed from: package-private */
    public OperationExecutor getExecutor() {
        return this.executor;
    }

    /* access modifiers changed from: package-private */
    public MongoNamespace getNamespace() {
        return new MongoNamespace(getDB().getName(), getName());
    }

    /* access modifiers changed from: package-private */
    public BufferProvider getBufferPool() {
        return getDB().getBufferPool();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public BsonDocument wrapAllowNull(@Nullable DBObject document) {
        if (document == null) {
            return null;
        }
        return wrap(document);
    }

    @Nullable
    List<BsonDocument> wrapAllowNull(@Nullable List<? extends DBObject> documentList, @Nullable DBEncoder encoder) {
        return wrapAllowNull(documentList, encoder == null ? null : new DBEncoderAdapter(encoder));
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public List<BsonDocument> wrapAllowNull(@Nullable List<? extends DBObject> documentList, @Nullable Encoder<DBObject> encoder) {
        if (documentList == null) {
            return null;
        }
        List<BsonDocument> wrappedDocumentList = new ArrayList<>(documentList.size());
        for (DBObject cur : documentList) {
            wrappedDocumentList.add(encoder == null ? wrap(cur) : wrap(cur, encoder));
        }
        return wrappedDocumentList;
    }

    BsonDocument wrap(DBObject document) {
        return new BsonDocumentWrapper(document, getDefaultDBObjectCodec());
    }

    BsonDocument wrap(DBObject document, @Nullable DBEncoder encoder) {
        if (encoder == null) {
            return wrap(document);
        }
        return new BsonDocumentWrapper(document, new DBEncoderAdapter(encoder));
    }

    BsonDocument wrap(DBObject document, @Nullable Encoder<DBObject> encoder) {
        if (encoder == null) {
            return wrap(document);
        }
        return new BsonDocumentWrapper(document, encoder);
    }

    /* access modifiers changed from: package-private */
    public static WriteConcernException createWriteConcernException(MongoWriteConcernException e) {
        return new WriteConcernException(new BsonDocument("code", new BsonInt32(e.getWriteConcernError().getCode())).append("errmsg", new BsonString(e.getWriteConcernError().getMessage())), e.getServerAddress(), e.getWriteResult());
    }
}
