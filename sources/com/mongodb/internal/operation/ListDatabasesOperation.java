package com.mongodb.internal.operation;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.AsyncBatchCursor;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncConnectionSource;
import com.mongodb.internal.binding.AsyncReadBinding;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.QueryResult;
import com.mongodb.internal.operation.CommandOperationHelper;
import java.util.concurrent.TimeUnit;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonValue;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/ListDatabasesOperation.class */
public class ListDatabasesOperation<T> implements AsyncReadOperation<AsyncBatchCursor<T>>, ReadOperation<BatchCursor<T>> {
    private final Decoder<T> decoder;
    private boolean retryReads;
    private long maxTimeMS;
    private BsonDocument filter;
    private Boolean nameOnly;
    private Boolean authorizedDatabasesOnly;

    public ListDatabasesOperation(Decoder<T> decoder) {
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public ListDatabasesOperation<T> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public ListDatabasesOperation<T> filter(BsonDocument filter) {
        this.filter = filter;
        return this;
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public ListDatabasesOperation<T> nameOnly(Boolean nameOnly) {
        this.nameOnly = nameOnly;
        return this;
    }

    public ListDatabasesOperation<T> authorizedDatabasesOnly(Boolean authorizedDatabasesOnly) {
        this.authorizedDatabasesOnly = authorizedDatabasesOnly;
        return this;
    }

    public ListDatabasesOperation<T> retryReads(boolean retryReads) {
        this.retryReads = retryReads;
        return this;
    }

    public boolean getRetryReads() {
        return this.retryReads;
    }

    public Boolean getNameOnly() {
        return this.nameOnly;
    }

    public Boolean getAuthorizedDatabasesOnly() {
        return this.authorizedDatabasesOnly;
    }

    @Override // com.mongodb.internal.operation.ReadOperation
    public BatchCursor<T> execute(ReadBinding binding) {
        return (BatchCursor) CommandOperationHelper.executeCommand(binding, "admin", getCommandCreator(), (Decoder) CommandResultDocumentCodec.create(this.decoder, "databases"), (CommandOperationHelper.CommandReadTransformer<D, Object>) transformer(), this.retryReads);
    }

    @Override // com.mongodb.internal.operation.AsyncReadOperation
    public void executeAsync(AsyncReadBinding binding, SingleResultCallback<AsyncBatchCursor<T>> callback) {
        CommandOperationHelper.executeCommandAsync(binding, "admin", getCommandCreator(), CommandResultDocumentCodec.create(this.decoder, "databases"), asyncTransformer(), this.retryReads, ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER));
    }

    private CommandOperationHelper.CommandReadTransformer<BsonDocument, BatchCursor<T>> transformer() {
        return new CommandOperationHelper.CommandReadTransformer<BsonDocument, BatchCursor<T>>() { // from class: com.mongodb.internal.operation.ListDatabasesOperation.1
            public BatchCursor<T> apply(BsonDocument result, ConnectionSource source, Connection connection) {
                return new QueryBatchCursor(ListDatabasesOperation.this.createQueryResult(result, connection.getDescription()), 0, 0, ListDatabasesOperation.this.decoder, source);
            }
        };
    }

    private CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>> asyncTransformer() {
        return new CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>>() { // from class: com.mongodb.internal.operation.ListDatabasesOperation.2
            public AsyncBatchCursor<T> apply(BsonDocument result, AsyncConnectionSource source, AsyncConnection connection) {
                return new AsyncQueryBatchCursor(ListDatabasesOperation.this.createQueryResult(result, connection.getDescription()), 0, 0, 0, ListDatabasesOperation.this.decoder, source, connection, result);
            }
        };
    }

    /* access modifiers changed from: private */
    public QueryResult<T> createQueryResult(BsonDocument result, ConnectionDescription description) {
        return new QueryResult<>(null, BsonDocumentWrapperHelper.toList(result, "databases"), 0, description.getServerAddress());
    }

    private CommandOperationHelper.CommandCreator getCommandCreator() {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.ListDatabasesOperation.3
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                return ListDatabasesOperation.this.getCommand();
            }
        };
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand() {
        BsonDocument command = new BsonDocument("listDatabases", new BsonInt32(1));
        if (this.maxTimeMS > 0) {
            command.put("maxTimeMS", (BsonValue) new BsonInt64(this.maxTimeMS));
        }
        if (this.filter != null) {
            command.put("filter", (BsonValue) this.filter);
        }
        if (this.nameOnly != null) {
            command.put("nameOnly", (BsonValue) new BsonBoolean(this.nameOnly.booleanValue()));
        }
        if (this.authorizedDatabasesOnly != null) {
            command.put("authorizedDatabases", (BsonValue) new BsonBoolean(this.authorizedDatabasesOnly.booleanValue()));
        }
        return command;
    }
}
