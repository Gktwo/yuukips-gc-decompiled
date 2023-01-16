package com.mongodb.internal.operation;

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
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonString;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/RenameCollectionOperation.class */
public class RenameCollectionOperation implements AsyncWriteOperation<Void>, WriteOperation<Void> {
    private final MongoNamespace originalNamespace;
    private final MongoNamespace newNamespace;
    private final WriteConcern writeConcern;
    private boolean dropTarget;

    public RenameCollectionOperation(MongoNamespace originalNamespace, MongoNamespace newNamespace) {
        this(originalNamespace, newNamespace, null);
    }

    public RenameCollectionOperation(MongoNamespace originalNamespace, MongoNamespace newNamespace, WriteConcern writeConcern) {
        this.originalNamespace = (MongoNamespace) Assertions.notNull("originalNamespace", originalNamespace);
        this.newNamespace = (MongoNamespace) Assertions.notNull("newNamespace", newNamespace);
        this.writeConcern = writeConcern;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public boolean isDropTarget() {
        return this.dropTarget;
    }

    public RenameCollectionOperation dropTarget(boolean dropTarget) {
        this.dropTarget = dropTarget;
        return this;
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public Void execute(final WriteBinding binding) {
        return (Void) OperationHelper.withConnection(binding, new OperationHelper.CallableWithConnection<Void>() { // from class: com.mongodb.internal.operation.RenameCollectionOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnection
            public Void call(Connection connection) {
                return (Void) CommandOperationHelper.executeCommand(binding, "admin", RenameCollectionOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorTransformer());
            }
        });
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(final AsyncWriteBinding binding, final SingleResultCallback<Void> callback) {
        OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.RenameCollectionOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection, Throwable t) {
                SingleResultCallback<Void> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                } else {
                    CommandOperationHelper.executeCommandAsync(binding, "admin", RenameCollectionOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorWriteTransformer(), OperationHelper.releasingCallback(errHandlingCallback, connection));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(ConnectionDescription description) {
        BsonDocument commandDocument = new BsonDocument("renameCollection", new BsonString(this.originalNamespace.getFullName())).append("to", new BsonString(this.newNamespace.getFullName())).append("dropTarget", BsonBoolean.valueOf(this.dropTarget));
        WriteConcernHelper.appendWriteConcernToCommand(this.writeConcern, commandDocument, description);
        return commandDocument;
    }
}
