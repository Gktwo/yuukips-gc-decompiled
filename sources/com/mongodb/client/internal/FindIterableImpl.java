package com.mongodb.client.internal;

import com.mongodb.CursorType;
import com.mongodb.ExplainVerbosity;
import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Collation;
import com.mongodb.internal.client.model.FindOptions;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.ExplainableReadOperation;
import com.mongodb.internal.operation.SyncOperations;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/FindIterableImpl.class */
class FindIterableImpl<TDocument, TResult> extends MongoIterableImpl<TResult> implements FindIterable<TResult> {
    private final SyncOperations<TDocument> operations;
    private final Class<TResult> resultClass;
    private final FindOptions findOptions;
    private final CodecRegistry codecRegistry;
    private Bson filter;

    FindIterableImpl(@Nullable ClientSession clientSession, MongoNamespace namespace, Class<TDocument> documentClass, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, ReadConcern readConcern, OperationExecutor executor, Bson filter) {
        this(clientSession, namespace, documentClass, resultClass, codecRegistry, readPreference, readConcern, executor, filter, true);
    }

    /* access modifiers changed from: package-private */
    public FindIterableImpl(@Nullable ClientSession clientSession, MongoNamespace namespace, Class<TDocument> documentClass, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, ReadConcern readConcern, OperationExecutor executor, Bson filter, boolean retryReads) {
        super(clientSession, executor, readConcern, readPreference, retryReads);
        this.operations = new SyncOperations<>(namespace, documentClass, readPreference, codecRegistry, retryReads);
        this.resultClass = (Class) Assertions.notNull("resultClass", resultClass);
        this.filter = (Bson) Assertions.notNull("filter", filter);
        this.findOptions = new FindOptions();
        this.codecRegistry = codecRegistry;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> filter(@Nullable Bson filter) {
        this.filter = filter;
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> limit(int limit) {
        this.findOptions.limit(limit);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> skip(int skip) {
        this.findOptions.skip(skip);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.findOptions.maxTime(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> maxAwaitTime(long maxAwaitTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.findOptions.maxAwaitTime(maxAwaitTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
    public FindIterable<TResult> batchSize(int batchSize) {
        batchSize(batchSize);
        this.findOptions.batchSize(batchSize);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> collation(@Nullable Collation collation) {
        this.findOptions.collation(collation);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> projection(@Nullable Bson projection) {
        this.findOptions.projection(projection);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> sort(@Nullable Bson sort) {
        this.findOptions.sort(sort);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> noCursorTimeout(boolean noCursorTimeout) {
        this.findOptions.noCursorTimeout(noCursorTimeout);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    @Deprecated
    public FindIterable<TResult> oplogReplay(boolean oplogReplay) {
        this.findOptions.oplogReplay(oplogReplay);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> partial(boolean partial) {
        this.findOptions.partial(partial);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> cursorType(CursorType cursorType) {
        this.findOptions.cursorType(cursorType);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> comment(@Nullable String comment) {
        this.findOptions.comment(comment);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> hint(@Nullable Bson hint) {
        this.findOptions.hint(hint);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> hintString(@Nullable String hint) {
        this.findOptions.hintString(hint);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> max(@Nullable Bson max) {
        this.findOptions.max(max);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> min(@Nullable Bson min) {
        this.findOptions.min(min);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> returnKey(boolean returnKey) {
        this.findOptions.returnKey(returnKey);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> showRecordId(boolean showRecordId) {
        this.findOptions.showRecordId(showRecordId);
        return this;
    }

    @Override // com.mongodb.client.FindIterable
    public FindIterable<TResult> allowDiskUse(@Nullable Boolean allowDiskUse) {
        this.findOptions.allowDiskUse(allowDiskUse);
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
    @Nullable
    public TResult first() {
        BatchCursor<TResult> batchCursor = (BatchCursor) getExecutor().execute(this.operations.findFirst(this.filter, this.resultClass, this.findOptions), getReadPreference(), getReadConcern(), getClientSession());
        try {
            return batchCursor.hasNext() ? batchCursor.next().iterator().next() : null;
        } finally {
            batchCursor.close();
        }
    }

    @Override // com.mongodb.client.FindIterable
    public Document explain() {
        return (Document) executeExplain(Document.class, null);
    }

    @Override // com.mongodb.client.FindIterable
    public Document explain(ExplainVerbosity verbosity) {
        return (Document) executeExplain(Document.class, (ExplainVerbosity) Assertions.notNull("verbosity", verbosity));
    }

    @Override // com.mongodb.client.FindIterable
    public <E> E explain(Class<E> explainDocumentClass) {
        return (E) executeExplain(explainDocumentClass, null);
    }

    @Override // com.mongodb.client.FindIterable
    public <E> E explain(Class<E> explainResultClass, ExplainVerbosity verbosity) {
        return (E) executeExplain(explainResultClass, (ExplainVerbosity) Assertions.notNull("verbosity", verbosity));
    }

    private <E> E executeExplain(Class<E> explainResultClass, @Nullable ExplainVerbosity verbosity) {
        Assertions.notNull("explainDocumentClass", explainResultClass);
        return (E) getExecutor().execute(asReadOperation().asExplainableOperation(verbosity, this.codecRegistry.get(explainResultClass)), getReadPreference(), getReadConcern(), getClientSession());
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl
    public ExplainableReadOperation<BatchCursor<TResult>> asReadOperation() {
        return this.operations.find(this.filter, this.resultClass, this.findOptions);
    }
}
