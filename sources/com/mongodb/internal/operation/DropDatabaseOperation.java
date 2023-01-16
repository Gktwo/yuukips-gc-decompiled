package com.mongodb.internal.operation;

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
import org.bson.BsonInt32;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/DropDatabaseOperation.class */
public class DropDatabaseOperation implements AsyncWriteOperation<Void>, WriteOperation<Void> {
    private static final BsonDocument DROP_DATABASE = new BsonDocument("dropDatabase", new BsonInt32(1));
    private final String databaseName;
    private final WriteConcern writeConcern;

    public DropDatabaseOperation(String databaseName) {
        this(databaseName, null);
    }

    public DropDatabaseOperation(String databaseName, WriteConcern writeConcern) {
        this.databaseName = (String) Assertions.notNull("databaseName", databaseName);
        this.writeConcern = writeConcern;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public Void execute(final WriteBinding binding) {
        return (Void) OperationHelper.withConnection(binding, new OperationHelper.CallableWithConnection<Void>() { // from class: com.mongodb.internal.operation.DropDatabaseOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnection
            public Void call(Connection connection) {
                CommandOperationHelper.executeCommand(binding, DropDatabaseOperation.this.databaseName, DropDatabaseOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorTransformer());
                return null;
            }
        });
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(final AsyncWriteBinding binding, final SingleResultCallback<Void> callback) {
        OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.DropDatabaseOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection, Throwable t) {
                SingleResultCallback<Void> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                } else {
                    CommandOperationHelper.executeCommandAsync(binding, DropDatabaseOperation.this.databaseName, DropDatabaseOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorWriteTransformer(), OperationHelper.releasingCallback(errHandlingCallback, connection));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(ConnectionDescription description) {
        BsonDocument commandDocument = new BsonDocument("dropDatabase", new BsonInt32(1));
        WriteConcernHelper.appendWriteConcernToCommand(this.writeConcern, commandDocument, description);
        return commandDocument;
    }
}
