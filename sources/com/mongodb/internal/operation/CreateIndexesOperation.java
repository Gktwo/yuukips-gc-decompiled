package com.mongodb.internal.operation;

import com.mongodb.CreateIndexCommitQuorum;
import com.mongodb.DuplicateKeyException;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoClientException;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.WriteConcernResult;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.bulk.IndexRequest;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.operation.OperationHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonArray;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonDouble;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonValue;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/CreateIndexesOperation.class */
public class CreateIndexesOperation implements AsyncWriteOperation<Void>, WriteOperation<Void> {
    private final MongoNamespace namespace;
    private final List<IndexRequest> requests;
    private final WriteConcern writeConcern;
    private long maxTimeMS;
    private CreateIndexCommitQuorum commitQuorum;

    public CreateIndexesOperation(MongoNamespace namespace, List<IndexRequest> requests) {
        this(namespace, requests, null);
    }

    public CreateIndexesOperation(MongoNamespace namespace, List<IndexRequest> requests, WriteConcern writeConcern) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.requests = (List) Assertions.notNull("indexRequests", requests);
        this.writeConcern = writeConcern;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public List<IndexRequest> getRequests() {
        return this.requests;
    }

    public List<String> getIndexNames() {
        List<String> indexNames = new ArrayList<>(this.requests.size());
        for (IndexRequest request : this.requests) {
            if (request.getName() != null) {
                indexNames.add(request.getName());
            } else {
                indexNames.add(IndexHelper.generateIndexName(request.getKeys()));
            }
        }
        return indexNames;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public CreateIndexesOperation maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        Assertions.isTrueArgument("maxTime >= 0", maxTime >= 0);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public CreateIndexCommitQuorum getCommitQuorum() {
        return this.commitQuorum;
    }

    public CreateIndexesOperation commitQuorum(CreateIndexCommitQuorum commitQuorum) {
        this.commitQuorum = commitQuorum;
        return this;
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public Void execute(final WriteBinding binding) {
        return (Void) OperationHelper.withConnection(binding, new OperationHelper.CallableWithConnection<Void>() { // from class: com.mongodb.internal.operation.CreateIndexesOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnection
            public Void call(Connection connection) {
                try {
                    OperationHelper.validateIndexRequestCollations(connection, CreateIndexesOperation.this.requests);
                    CommandOperationHelper.executeCommand(binding, CreateIndexesOperation.this.namespace.getDatabaseName(), CreateIndexesOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorTransformer());
                    return null;
                } catch (MongoCommandException e) {
                    throw CreateIndexesOperation.this.checkForDuplicateKeyError(e);
                }
            }
        });
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(final AsyncWriteBinding binding, final SingleResultCallback<Void> callback) {
        OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.CreateIndexesOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection, Throwable t) {
                SingleResultCallback<Void> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                    return;
                }
                final SingleResultCallback<Void> wrappedCallback = OperationHelper.releasingCallback(errHandlingCallback, connection);
                OperationHelper.validateIndexRequestCollations(connection, CreateIndexesOperation.this.requests, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.CreateIndexesOperation.2.1
                    @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
                    public void call(AsyncConnection connection2, Throwable t2) {
                        if (t2 != null) {
                            wrappedCallback.onResult(null, t2);
                            return;
                        }
                        try {
                            CommandOperationHelper.executeCommandAsync(binding, CreateIndexesOperation.this.namespace.getDatabaseName(), CreateIndexesOperation.this.getCommand(connection2.getDescription()), connection2, CommandOperationHelper.writeConcernErrorWriteTransformer(), new SingleResultCallback<Void>() { // from class: com.mongodb.internal.operation.CreateIndexesOperation.2.1.1
                                public void onResult(Void result, Throwable t3) {
                                    wrappedCallback.onResult(null, CreateIndexesOperation.this.translateException(t3));
                                }
                            });
                        } catch (Throwable t1) {
                            wrappedCallback.onResult(null, t1);
                        }
                    }
                });
            }
        });
    }

    private BsonDocument getIndex(IndexRequest request) {
        BsonDocument index = new BsonDocument();
        index.append(Action.KEY_ATTRIBUTE, request.getKeys());
        index.append("name", new BsonString(request.getName() != null ? request.getName() : IndexHelper.generateIndexName(request.getKeys())));
        index.append("ns", new BsonString(this.namespace.getFullName()));
        if (request.isBackground()) {
            index.append("background", BsonBoolean.TRUE);
        }
        if (request.isUnique()) {
            index.append("unique", BsonBoolean.TRUE);
        }
        if (request.isSparse()) {
            index.append("sparse", BsonBoolean.TRUE);
        }
        if (request.getExpireAfter(TimeUnit.SECONDS) != null) {
            index.append("expireAfterSeconds", new BsonInt64(request.getExpireAfter(TimeUnit.SECONDS).longValue()));
        }
        if (request.getVersion() != null) {
            index.append("v", new BsonInt32(request.getVersion().intValue()));
        }
        if (request.getWeights() != null) {
            index.append("weights", request.getWeights());
        }
        if (request.getDefaultLanguage() != null) {
            index.append("default_language", new BsonString(request.getDefaultLanguage()));
        }
        if (request.getLanguageOverride() != null) {
            index.append("language_override", new BsonString(request.getLanguageOverride()));
        }
        if (request.getTextVersion() != null) {
            index.append("textIndexVersion", new BsonInt32(request.getTextVersion().intValue()));
        }
        if (request.getSphereVersion() != null) {
            index.append("2dsphereIndexVersion", new BsonInt32(request.getSphereVersion().intValue()));
        }
        if (request.getBits() != null) {
            index.append("bits", new BsonInt32(request.getBits().intValue()));
        }
        if (request.getMin() != null) {
            index.append("min", new BsonDouble(request.getMin().doubleValue()));
        }
        if (request.getMax() != null) {
            index.append("max", new BsonDouble(request.getMax().doubleValue()));
        }
        if (request.getBucketSize() != null) {
            index.append("bucketSize", new BsonDouble(request.getBucketSize().doubleValue()));
        }
        if (request.getDropDups()) {
            index.append("dropDups", BsonBoolean.TRUE);
        }
        if (request.getStorageEngine() != null) {
            index.append("storageEngine", request.getStorageEngine());
        }
        if (request.getPartialFilterExpression() != null) {
            index.append("partialFilterExpression", request.getPartialFilterExpression());
        }
        if (request.getCollation() != null) {
            index.append("collation", request.getCollation().asDocument());
        }
        if (request.getWildcardProjection() != null) {
            index.append("wildcardProjection", request.getWildcardProjection());
        }
        if (request.isHidden()) {
            index.append("hidden", BsonBoolean.TRUE);
        }
        return index;
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(ConnectionDescription description) {
        BsonDocument command = new BsonDocument("createIndexes", new BsonString(this.namespace.getCollectionName()));
        List<BsonDocument> values = new ArrayList<>();
        for (IndexRequest request : this.requests) {
            values.add(getIndex(request));
        }
        command.put("indexes", (BsonValue) new BsonArray(values));
        DocumentHelper.putIfNotZero(command, "maxTimeMS", this.maxTimeMS);
        WriteConcernHelper.appendWriteConcernToCommand(this.writeConcern, command, description);
        if (this.commitQuorum != null) {
            if (ServerVersionHelper.serverIsAtLeastVersionFourDotFour(description)) {
                command.put("commitQuorum", this.commitQuorum.toBsonValue());
            } else {
                throw new MongoClientException("Specifying a value for the create index commit quorum option requires a minimum MongoDB version of 4.4");
            }
        }
        return command;
    }

    /* access modifiers changed from: private */
    public MongoException translateException(Throwable t) {
        return t instanceof MongoCommandException ? checkForDuplicateKeyError((MongoCommandException) t) : MongoException.fromThrowable(t);
    }

    /* access modifiers changed from: private */
    public MongoException checkForDuplicateKeyError(MongoCommandException e) {
        if (ErrorCategory.fromErrorCode(e.getCode()) == ErrorCategory.DUPLICATE_KEY) {
            return new DuplicateKeyException(e.getResponse(), e.getServerAddress(), WriteConcernResult.acknowledged(0, false, null));
        }
        return e;
    }
}
