package com.mongodb.internal.operation;

import com.mongodb.MongoNamespace;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
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
import com.mongodb.internal.session.SessionContext;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.Codec;
import org.bson.codecs.Decoder;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/DistinctOperation.class */
public class DistinctOperation<T> implements AsyncReadOperation<AsyncBatchCursor<T>>, ReadOperation<BatchCursor<T>> {
    private static final String VALUES = "values";
    private final MongoNamespace namespace;
    private final String fieldName;
    private final Decoder<T> decoder;
    private boolean retryReads;
    private BsonDocument filter;
    private long maxTimeMS;
    private Collation collation;

    public DistinctOperation(MongoNamespace namespace, String fieldName, Decoder<T> decoder) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.fieldName = (String) Assertions.notNull("fieldName", fieldName);
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public DistinctOperation<T> filter(BsonDocument filter) {
        this.filter = filter;
        return this;
    }

    public DistinctOperation<T> retryReads(boolean retryReads) {
        this.retryReads = retryReads;
        return this;
    }

    public boolean getRetryReads() {
        return this.retryReads;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public DistinctOperation<T> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public DistinctOperation<T> collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    @Override // com.mongodb.internal.operation.ReadOperation
    public BatchCursor<T> execute(ReadBinding binding) {
        return (BatchCursor) CommandOperationHelper.executeCommand(binding, this.namespace.getDatabaseName(), getCommandCreator(binding.getSessionContext()), (Decoder) createCommandDecoder(), (CommandOperationHelper.CommandReadTransformer<D, Object>) transformer(), this.retryReads);
    }

    @Override // com.mongodb.internal.operation.AsyncReadOperation
    public void executeAsync(AsyncReadBinding binding, SingleResultCallback<AsyncBatchCursor<T>> callback) {
        CommandOperationHelper.executeCommandAsync(binding, this.namespace.getDatabaseName(), getCommandCreator(binding.getSessionContext()), createCommandDecoder(), asyncTransformer(), this.retryReads, ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER));
    }

    private Codec<BsonDocument> createCommandDecoder() {
        return CommandResultDocumentCodec.create(this.decoder, VALUES);
    }

    /* access modifiers changed from: private */
    public QueryResult<T> createQueryResult(BsonDocument result, ConnectionDescription description) {
        return new QueryResult<>(this.namespace, BsonDocumentWrapperHelper.toList(result, VALUES), 0, description.getServerAddress());
    }

    private CommandOperationHelper.CommandReadTransformer<BsonDocument, BatchCursor<T>> transformer() {
        return new CommandOperationHelper.CommandReadTransformer<BsonDocument, BatchCursor<T>>() { // from class: com.mongodb.internal.operation.DistinctOperation.1
            public BatchCursor<T> apply(BsonDocument result, ConnectionSource source, Connection connection) {
                return new QueryBatchCursor(DistinctOperation.this.createQueryResult(result, connection.getDescription()), 0, 0, DistinctOperation.this.decoder, source);
            }
        };
    }

    private CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>> asyncTransformer() {
        return new CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>>() { // from class: com.mongodb.internal.operation.DistinctOperation.2
            public AsyncBatchCursor<T> apply(BsonDocument result, AsyncConnectionSource source, AsyncConnection connection) {
                return new AsyncSingleBatchQueryCursor(DistinctOperation.this.createQueryResult(result, connection.getDescription()));
            }
        };
    }

    private CommandOperationHelper.CommandCreator getCommandCreator(final SessionContext sessionContext) {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.DistinctOperation.3
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                OperationHelper.validateReadConcernAndCollation(connectionDescription, sessionContext.getReadConcern(), DistinctOperation.this.collation);
                return DistinctOperation.this.getCommand(sessionContext);
            }
        };
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(SessionContext sessionContext) {
        BsonDocument commandDocument = new BsonDocument("distinct", new BsonString(this.namespace.getCollectionName()));
        OperationReadConcernHelper.appendReadConcernToCommand(sessionContext, commandDocument);
        commandDocument.put(Action.KEY_ATTRIBUTE, (BsonValue) new BsonString(this.fieldName));
        DocumentHelper.putIfNotNullOrEmpty(commandDocument, "query", this.filter);
        DocumentHelper.putIfNotZero(commandDocument, "maxTimeMS", this.maxTimeMS);
        if (this.collation != null) {
            commandDocument.put("collation", (BsonValue) this.collation.asDocument());
        }
        return commandDocument;
    }
}
