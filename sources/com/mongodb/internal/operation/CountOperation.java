package com.mongodb.internal.operation;

import com.mongodb.DBCollection;
import com.mongodb.MongoNamespace;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.AsyncBatchCursor;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncConnectionSource;
import com.mongodb.internal.binding.AsyncReadBinding;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.client.model.CountStrategy;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.operation.CommandOperationHelper;
import com.mongodb.internal.session.SessionContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/CountOperation.class */
public class CountOperation implements AsyncReadOperation<Long>, ReadOperation<Long> {
    private static final Decoder<BsonDocument> DECODER = new BsonDocumentCodec();
    private final MongoNamespace namespace;
    private final CountStrategy countStrategy;
    private boolean retryReads;
    private BsonDocument filter;
    private BsonValue hint;
    private long skip;
    private long limit;
    private long maxTimeMS;
    private Collation collation;

    public CountOperation(MongoNamespace namespace) {
        this(namespace, CountStrategy.COMMAND);
    }

    public CountOperation(MongoNamespace namespace, CountStrategy countStrategy) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.countStrategy = (CountStrategy) Assertions.notNull("countStrategy", countStrategy);
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public CountOperation filter(BsonDocument filter) {
        this.filter = filter;
        return this;
    }

    public CountOperation retryReads(boolean retryReads) {
        this.retryReads = retryReads;
        return this;
    }

    public boolean getRetryReads() {
        return this.retryReads;
    }

    public BsonValue getHint() {
        return this.hint;
    }

    public CountOperation hint(BsonValue hint) {
        this.hint = hint;
        return this;
    }

    public long getLimit() {
        return this.limit;
    }

    public CountOperation limit(long limit) {
        this.limit = limit;
        return this;
    }

    public long getSkip() {
        return this.skip;
    }

    public CountOperation skip(long skip) {
        this.skip = skip;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public CountOperation maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public CountOperation collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    @Override // com.mongodb.internal.operation.ReadOperation
    public Long execute(ReadBinding binding) {
        if (this.countStrategy.equals(CountStrategy.COMMAND)) {
            return (Long) CommandOperationHelper.executeCommand(binding, this.namespace.getDatabaseName(), getCommandCreator(binding.getSessionContext()), (Decoder) DECODER, (CommandOperationHelper.CommandReadTransformer<D, Object>) transformer(), this.retryReads);
        }
        BatchCursor<BsonDocument> cursor = getAggregateOperation().execute(binding);
        return Long.valueOf(cursor.hasNext() ? getCountFromAggregateResults(cursor.next()).longValue() : 0);
    }

    @Override // com.mongodb.internal.operation.AsyncReadOperation
    public void executeAsync(AsyncReadBinding binding, final SingleResultCallback<Long> callback) {
        if (this.countStrategy.equals(CountStrategy.COMMAND)) {
            CommandOperationHelper.executeCommandAsync(binding, this.namespace.getDatabaseName(), getCommandCreator(binding.getSessionContext()), DECODER, asyncTransformer(), this.retryReads, callback);
        } else {
            getAggregateOperation().executeAsync(binding, new SingleResultCallback<AsyncBatchCursor<BsonDocument>>() { // from class: com.mongodb.internal.operation.CountOperation.1
                public void onResult(AsyncBatchCursor<BsonDocument> result, Throwable t) {
                    if (t != null) {
                        callback.onResult(null, t);
                    } else {
                        result.next(new SingleResultCallback<List<BsonDocument>>() { // from class: com.mongodb.internal.operation.CountOperation.1.1
                            public void onResult(List<BsonDocument> result2, Throwable t2) {
                                if (t2 != null) {
                                    callback.onResult(null, t2);
                                } else {
                                    callback.onResult(CountOperation.this.getCountFromAggregateResults(result2), null);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private CommandOperationHelper.CommandReadTransformer<BsonDocument, Long> transformer() {
        return new CommandOperationHelper.CommandReadTransformer<BsonDocument, Long>() { // from class: com.mongodb.internal.operation.CountOperation.2
            public Long apply(BsonDocument result, ConnectionSource source, Connection connection) {
                return Long.valueOf(result.getNumber("n").longValue());
            }
        };
    }

    private CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, Long> asyncTransformer() {
        return new CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, Long>() { // from class: com.mongodb.internal.operation.CountOperation.3
            public Long apply(BsonDocument result, AsyncConnectionSource source, AsyncConnection connection) {
                return Long.valueOf(result.getNumber("n").longValue());
            }
        };
    }

    private CommandOperationHelper.CommandCreator getCommandCreator(final SessionContext sessionContext) {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.CountOperation.4
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                OperationHelper.validateReadConcernAndCollation(connectionDescription, sessionContext.getReadConcern(), CountOperation.this.collation);
                return CountOperation.this.getCommand(sessionContext);
            }
        };
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(SessionContext sessionContext) {
        BsonDocument document = new BsonDocument("count", new BsonString(this.namespace.getCollectionName()));
        OperationReadConcernHelper.appendReadConcernToCommand(sessionContext, document);
        DocumentHelper.putIfNotNull(document, "query", this.filter);
        DocumentHelper.putIfNotZero(document, "limit", this.limit);
        DocumentHelper.putIfNotZero(document, "skip", this.skip);
        DocumentHelper.putIfNotNull(document, "hint", this.hint);
        DocumentHelper.putIfNotZero(document, "maxTimeMS", this.maxTimeMS);
        if (this.collation != null) {
            document.put("collation", (BsonValue) this.collation.asDocument());
        }
        return document;
    }

    private AggregateOperation<BsonDocument> getAggregateOperation() {
        return new AggregateOperation(this.namespace, getPipeline(), DECODER).retryReads(this.retryReads).collation(this.collation).hint(this.hint).maxTime(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    private List<BsonDocument> getPipeline() {
        ArrayList<BsonDocument> pipeline = new ArrayList<>();
        pipeline.add(new BsonDocument("$match", this.filter != null ? this.filter : new BsonDocument()));
        if (this.skip > 0) {
            pipeline.add(new BsonDocument("$skip", new BsonInt64(this.skip)));
        }
        if (this.limit > 0) {
            pipeline.add(new BsonDocument("$limit", new BsonInt64(this.limit)));
        }
        pipeline.add(new BsonDocument("$group", new BsonDocument(DBCollection.ID_FIELD_NAME, new BsonInt32(1)).append("n", new BsonDocument("$sum", new BsonInt32(1)))));
        return pipeline;
    }

    /* access modifiers changed from: private */
    public Long getCountFromAggregateResults(List<BsonDocument> results) {
        if (results == null || results.isEmpty()) {
            return 0L;
        }
        return Long.valueOf(results.get(0).getNumber("n").longValue());
    }
}
