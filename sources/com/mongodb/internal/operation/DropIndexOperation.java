package com.mongodb.internal.operation;

import com.mongodb.MongoCommandException;
import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.operation.OperationHelper;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/DropIndexOperation.class */
public class DropIndexOperation implements AsyncWriteOperation<Void>, WriteOperation<Void> {
    private final MongoNamespace namespace;
    private final String indexName;
    private final BsonDocument indexKeys;
    private final WriteConcern writeConcern;
    private long maxTimeMS;

    public DropIndexOperation(MongoNamespace namespace, String indexName) {
        this(namespace, indexName, (WriteConcern) null);
    }

    public DropIndexOperation(MongoNamespace namespace, BsonDocument keys) {
        this(namespace, keys, (WriteConcern) null);
    }

    public DropIndexOperation(MongoNamespace namespace, String indexName, WriteConcern writeConcern) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.indexName = (String) Assertions.notNull("indexName", indexName);
        this.indexKeys = null;
        this.writeConcern = writeConcern;
    }

    public DropIndexOperation(MongoNamespace namespace, BsonDocument indexKeys, WriteConcern writeConcern) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.indexKeys = (BsonDocument) Assertions.notNull("indexKeys", indexKeys);
        this.indexName = null;
        this.writeConcern = writeConcern;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public DropIndexOperation maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        Assertions.isTrueArgument("maxTime >= 0", maxTime >= 0);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public Void execute(final WriteBinding binding) {
        return (Void) OperationHelper.withConnection(binding, new OperationHelper.CallableWithConnection<Void>() { // from class: com.mongodb.internal.operation.DropIndexOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnection
            public Void call(Connection connection) {
                try {
                    CommandOperationHelper.executeCommand(binding, DropIndexOperation.this.namespace.getDatabaseName(), DropIndexOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorTransformer());
                    return null;
                } catch (MongoCommandException e) {
                    CommandOperationHelper.rethrowIfNotNamespaceError(e);
                    return null;
                }
            }
        });
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(final AsyncWriteBinding binding, final SingleResultCallback<Void> callback) {
        OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.DropIndexOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection, Throwable t) {
                SingleResultCallback<Void> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                    return;
                }
                final SingleResultCallback<Void> releasingCallback = OperationHelper.releasingCallback(errHandlingCallback, connection);
                CommandOperationHelper.executeCommandAsync(binding, DropIndexOperation.this.namespace.getDatabaseName(), DropIndexOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorWriteTransformer(), new SingleResultCallback<Void>() { // from class: com.mongodb.internal.operation.DropIndexOperation.2.1
                    public void onResult(Void result, Throwable t2) {
                        if (t2 == null || CommandOperationHelper.isNamespaceError(t2)) {
                            releasingCallback.onResult(result, null);
                        } else {
                            releasingCallback.onResult(null, t2);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(ConnectionDescription description) {
        BsonDocument command = new BsonDocument("dropIndexes", new BsonString(this.namespace.getCollectionName()));
        if (this.indexName != null) {
            command.put("index", (BsonValue) new BsonString(this.indexName));
        } else {
            command.put("index", (BsonValue) this.indexKeys);
        }
        DocumentHelper.putIfNotZero(command, "maxTimeMS", this.maxTimeMS);
        WriteConcernHelper.appendWriteConcernToCommand(this.writeConcern, command, description);
        return command;
    }
}
