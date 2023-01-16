package com.mongodb.internal.operation;

import com.mongodb.MongoClientException;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.operation.OperationHelper;
import java.util.List;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/CreateViewOperation.class */
public class CreateViewOperation implements AsyncWriteOperation<Void>, WriteOperation<Void> {
    private final String databaseName;
    private final String viewName;
    private final String viewOn;
    private final List<BsonDocument> pipeline;
    private final WriteConcern writeConcern;
    private Collation collation;

    public CreateViewOperation(String databaseName, String viewName, String viewOn, List<BsonDocument> pipeline, WriteConcern writeConcern) {
        this.databaseName = (String) Assertions.notNull("databaseName", databaseName);
        this.viewName = (String) Assertions.notNull("viewName", viewName);
        this.viewOn = (String) Assertions.notNull("viewOn", viewOn);
        this.pipeline = (List) Assertions.notNull("pipeline", pipeline);
        this.writeConcern = (WriteConcern) Assertions.notNull("writeConcern", writeConcern);
    }

    public String getDatabaseName() {
        return this.databaseName;
    }

    public String getViewName() {
        return this.viewName;
    }

    public String getViewOn() {
        return this.viewOn;
    }

    public List<BsonDocument> getPipeline() {
        return this.pipeline;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public CreateViewOperation collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public Void execute(final WriteBinding binding) {
        return (Void) OperationHelper.withConnection(binding, new OperationHelper.CallableWithConnection<Void>() { // from class: com.mongodb.internal.operation.CreateViewOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnection
            public Void call(Connection connection) {
                if (!ServerVersionHelper.serverIsAtLeastVersionThreeDotFour(connection.getDescription())) {
                    throw CreateViewOperation.this.createExceptionForIncompatibleServerVersion();
                }
                CommandOperationHelper.executeCommand(binding, CreateViewOperation.this.databaseName, CreateViewOperation.this.getCommand(connection.getDescription()), CommandOperationHelper.writeConcernErrorTransformer());
                return null;
            }
        });
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(final AsyncWriteBinding binding, final SingleResultCallback<Void> callback) {
        OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.CreateViewOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection, Throwable t) {
                SingleResultCallback<Void> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                    return;
                }
                SingleResultCallback<Void> wrappedCallback = OperationHelper.releasingCallback(errHandlingCallback, connection);
                if (!ServerVersionHelper.serverIsAtLeastVersionThreeDotFour(connection.getDescription())) {
                    wrappedCallback.onResult(null, CreateViewOperation.this.createExceptionForIncompatibleServerVersion());
                }
                CommandOperationHelper.executeCommandAsync(binding, CreateViewOperation.this.databaseName, CreateViewOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorWriteTransformer(), wrappedCallback);
            }
        });
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(ConnectionDescription description) {
        BsonDocument commandDocument = new BsonDocument("create", new BsonString(this.viewName)).append("viewOn", new BsonString(this.viewOn)).append("pipeline", new BsonArray(this.pipeline));
        if (this.collation != null) {
            commandDocument.put("collation", (BsonValue) this.collation.asDocument());
        }
        WriteConcernHelper.appendWriteConcernToCommand(this.writeConcern, commandDocument, description);
        return commandDocument;
    }

    /* access modifiers changed from: private */
    public MongoClientException createExceptionForIncompatibleServerVersion() {
        return new MongoClientException("Can not create view.  The minimum server version that supports view creation is 3.4");
    }
}
