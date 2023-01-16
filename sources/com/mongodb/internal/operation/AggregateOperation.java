package com.mongodb.internal.operation;

import com.mongodb.ExplainVerbosity;
import com.mongodb.MongoNamespace;
import com.mongodb.client.model.Collation;
import com.mongodb.internal.async.AsyncBatchCursor;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncReadBinding;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.client.model.AggregationLevel;
import com.mongodb.internal.connection.NoOpSessionContext;
import com.mongodb.lang.Nullable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonValue;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AggregateOperation.class */
public class AggregateOperation<T> implements AsyncExplainableReadOperation<AsyncBatchCursor<T>>, ExplainableReadOperation<BatchCursor<T>> {
    private final AggregateOperationImpl<T> wrapped;

    public AggregateOperation(MongoNamespace namespace, List<BsonDocument> pipeline, Decoder<T> decoder) {
        this(namespace, pipeline, decoder, AggregationLevel.COLLECTION);
    }

    public AggregateOperation(MongoNamespace namespace, List<BsonDocument> pipeline, Decoder<T> decoder, AggregationLevel aggregationLevel) {
        this.wrapped = new AggregateOperationImpl<>(namespace, pipeline, decoder, aggregationLevel);
    }

    public List<BsonDocument> getPipeline() {
        return this.wrapped.getPipeline();
    }

    public Boolean getAllowDiskUse() {
        return this.wrapped.getAllowDiskUse();
    }

    public AggregateOperation<T> allowDiskUse(Boolean allowDiskUse) {
        this.wrapped.allowDiskUse(allowDiskUse);
        return this;
    }

    public Integer getBatchSize() {
        return this.wrapped.getBatchSize();
    }

    public AggregateOperation<T> batchSize(Integer batchSize) {
        this.wrapped.batchSize(batchSize);
        return this;
    }

    public long getMaxAwaitTime(TimeUnit timeUnit) {
        return this.wrapped.getMaxAwaitTime(timeUnit);
    }

    public AggregateOperation<T> maxAwaitTime(long maxAwaitTime, TimeUnit timeUnit) {
        this.wrapped.maxAwaitTime(maxAwaitTime, timeUnit);
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        return this.wrapped.getMaxTime(timeUnit);
    }

    public AggregateOperation<T> maxTime(long maxTime, TimeUnit timeUnit) {
        this.wrapped.maxTime(maxTime, timeUnit);
        return this;
    }

    public Collation getCollation() {
        return this.wrapped.getCollation();
    }

    public AggregateOperation<T> collation(Collation collation) {
        this.wrapped.collation(collation);
        return this;
    }

    public String getComment() {
        return this.wrapped.getComment();
    }

    public AggregateOperation<T> comment(String comment) {
        this.wrapped.comment(comment);
        return this;
    }

    public AggregateOperation<T> retryReads(boolean retryReads) {
        this.wrapped.retryReads(retryReads);
        return this;
    }

    public boolean getRetryReads() {
        return this.wrapped.getRetryReads();
    }

    public BsonDocument getHint() {
        BsonValue hint = this.wrapped.getHint();
        if (hint == null) {
            return null;
        }
        if (hint.isDocument()) {
            return hint.asDocument();
        }
        throw new IllegalArgumentException("Hint is not a BsonDocument please use the #getHintBsonValue() method. ");
    }

    public BsonValue getHintBsonValue() {
        return this.wrapped.getHint();
    }

    public AggregateOperation<T> hint(BsonValue hint) {
        this.wrapped.hint(hint);
        return this;
    }

    @Override // com.mongodb.internal.operation.ReadOperation
    public BatchCursor<T> execute(ReadBinding binding) {
        return this.wrapped.execute(binding);
    }

    @Override // com.mongodb.internal.operation.AsyncReadOperation
    public void executeAsync(AsyncReadBinding binding, SingleResultCallback<AsyncBatchCursor<T>> callback) {
        this.wrapped.executeAsync(binding, callback);
    }

    @Override // com.mongodb.internal.operation.ExplainableReadOperation
    public <R> ReadOperation<R> asExplainableOperation(@Nullable ExplainVerbosity verbosity, Decoder<R> resultDecoder) {
        return new CommandReadOperation(getNamespace().getDatabaseName(), ExplainHelper.asExplainCommand(this.wrapped.getCommand(NoOpSessionContext.INSTANCE), verbosity), resultDecoder);
    }

    @Override // com.mongodb.internal.operation.AsyncExplainableReadOperation
    public <R> AsyncReadOperation<R> asAsyncExplainableOperation(@Nullable ExplainVerbosity verbosity, Decoder<R> resultDecoder) {
        return new CommandReadOperation(getNamespace().getDatabaseName(), ExplainHelper.asExplainCommand(this.wrapped.getCommand(NoOpSessionContext.INSTANCE), verbosity), resultDecoder);
    }

    MongoNamespace getNamespace() {
        return this.wrapped.getNamespace();
    }

    Decoder<T> getDecoder() {
        return this.wrapped.getDecoder();
    }

    public String toString() {
        return "AggregateOperation{namespace=" + getNamespace() + ", pipeline=" + getPipeline() + ", decoder=" + getDecoder() + ", allowDiskUse=" + getAllowDiskUse() + ", batchSize=" + getBatchSize() + ", collation=" + getCollation() + ", comment=" + getComment() + ", hint=" + getHint() + ", maxAwaitTimeMS=" + getMaxAwaitTime(TimeUnit.MILLISECONDS) + ", maxTimeMS=" + getMaxTime(TimeUnit.MILLISECONDS) + "}";
    }
}
