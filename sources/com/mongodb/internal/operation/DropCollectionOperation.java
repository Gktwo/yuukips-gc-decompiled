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
import org.bson.BsonDocument;
import org.bson.BsonString;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/DropCollectionOperation.class */
public class DropCollectionOperation implements AsyncWriteOperation<Void>, WriteOperation<Void> {
    private final MongoNamespace namespace;
    private final WriteConcern writeConcern;

    public DropCollectionOperation(MongoNamespace namespace) {
        this(namespace, null);
    }

    public DropCollectionOperation(MongoNamespace namespace, WriteConcern writeConcern) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.writeConcern = writeConcern;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public Void execute(final WriteBinding binding) {
        return (Void) OperationHelper.withConnection(binding, new OperationHelper.CallableWithConnection<Void>() { // from class: com.mongodb.internal.operation.DropCollectionOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnection
            public Void call(Connection connection) {
                try {
                    CommandOperationHelper.executeCommand(binding, DropCollectionOperation.this.namespace.getDatabaseName(), DropCollectionOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorTransformer());
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
        OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.DropCollectionOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection, Throwable t) {
                SingleResultCallback<Void> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                    return;
                }
                final SingleResultCallback<Void> releasingCallback = OperationHelper.releasingCallback(errHandlingCallback, connection);
                CommandOperationHelper.executeCommandAsync(binding, DropCollectionOperation.this.namespace.getDatabaseName(), DropCollectionOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorWriteTransformer(), new SingleResultCallback<Void>() { // from class: com.mongodb.internal.operation.DropCollectionOperation.2.1
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
        BsonDocument commandDocument = new BsonDocument("drop", new BsonString(this.namespace.getCollectionName()));
        WriteConcernHelper.appendWriteConcernToCommand(this.writeConcern, commandDocument, description);
        return commandDocument;
    }
}
