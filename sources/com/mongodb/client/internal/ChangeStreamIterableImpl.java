package com.mongodb.client.internal;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoChangeStreamCursor;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import com.mongodb.client.model.changestream.FullDocument;
import com.mongodb.internal.client.model.changestream.ChangeStreamLevel;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.ChangeStreamOperation;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonTimestamp;
import org.bson.RawBsonDocument;
import org.bson.codecs.Codec;
import org.bson.codecs.RawBsonDocumentCodec;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/ChangeStreamIterableImpl.class */
public class ChangeStreamIterableImpl<TResult> extends MongoIterableImpl<ChangeStreamDocument<TResult>> implements ChangeStreamIterable<TResult> {
    private final MongoNamespace namespace;
    private final CodecRegistry codecRegistry;
    private final List<? extends Bson> pipeline;
    private final Codec<ChangeStreamDocument<TResult>> codec;
    private final ChangeStreamLevel changeStreamLevel;
    private FullDocument fullDocument;
    private BsonDocument resumeToken;
    private BsonDocument startAfter;
    private long maxAwaitTimeMS;
    private Collation collation;
    private BsonTimestamp startAtOperationTime;

    public ChangeStreamIterableImpl(@Nullable ClientSession clientSession, String databaseName, CodecRegistry codecRegistry, ReadPreference readPreference, ReadConcern readConcern, OperationExecutor executor, List<? extends Bson> pipeline, Class<TResult> resultClass, ChangeStreamLevel changeStreamLevel, boolean retryReads) {
        this(clientSession, new MongoNamespace(databaseName, "ignored"), codecRegistry, readPreference, readConcern, executor, pipeline, resultClass, changeStreamLevel, retryReads);
    }

    public ChangeStreamIterableImpl(@Nullable ClientSession clientSession, MongoNamespace namespace, CodecRegistry codecRegistry, ReadPreference readPreference, ReadConcern readConcern, OperationExecutor executor, List<? extends Bson> pipeline, Class<TResult> resultClass, ChangeStreamLevel changeStreamLevel, boolean retryReads) {
        super(clientSession, executor, readConcern, readPreference, retryReads);
        this.fullDocument = FullDocument.DEFAULT;
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.codecRegistry = (CodecRegistry) Assertions.notNull("codecRegistry", codecRegistry);
        this.pipeline = (List) Assertions.notNull("pipeline", pipeline);
        this.codec = ChangeStreamDocument.createCodec((Class) Assertions.notNull("resultClass", resultClass), codecRegistry);
        this.changeStreamLevel = (ChangeStreamLevel) Assertions.notNull("changeStreamLevel", changeStreamLevel);
    }

    @Override // com.mongodb.client.ChangeStreamIterable
    public ChangeStreamIterable<TResult> fullDocument(FullDocument fullDocument) {
        this.fullDocument = (FullDocument) Assertions.notNull("fullDocument", fullDocument);
        return this;
    }

    @Override // com.mongodb.client.ChangeStreamIterable
    public ChangeStreamIterable<TResult> resumeAfter(BsonDocument resumeAfter) {
        this.resumeToken = (BsonDocument) Assertions.notNull("resumeAfter", resumeAfter);
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
    public ChangeStreamIterable<TResult> batchSize(int batchSize) {
        batchSize(batchSize);
        return this;
    }

    @Override // com.mongodb.client.ChangeStreamIterable
    public ChangeStreamIterable<TResult> maxAwaitTime(long maxAwaitTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxAwaitTimeMS = TimeUnit.MILLISECONDS.convert(maxAwaitTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.ChangeStreamIterable
    public ChangeStreamIterable<TResult> collation(@Nullable Collation collation) {
        this.collation = (Collation) Assertions.notNull("collation", collation);
        return this;
    }

    @Override // com.mongodb.client.ChangeStreamIterable
    public <TDocument> MongoIterable<TDocument> withDocumentClass(final Class<TDocument> clazz) {
        return new MongoIterableImpl<TDocument>(getClientSession(), getExecutor(), getReadConcern(), getReadPreference(), getRetryReads()) { // from class: com.mongodb.client.internal.ChangeStreamIterableImpl.1
            @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable, java.lang.Iterable
            public MongoCursor<TDocument> iterator() {
                return cursor();
            }

            @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
            public MongoChangeStreamCursor<TDocument> cursor() {
                return new MongoChangeStreamCursorImpl(ChangeStreamIterableImpl.this.execute(), ChangeStreamIterableImpl.this.codecRegistry.get(clazz), ChangeStreamIterableImpl.this.initialResumeToken());
            }

            @Override // com.mongodb.client.internal.MongoIterableImpl
            public ReadOperation<BatchCursor<TDocument>> asReadOperation() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // com.mongodb.client.ChangeStreamIterable
    public ChangeStreamIterable<TResult> startAtOperationTime(BsonTimestamp startAtOperationTime) {
        this.startAtOperationTime = (BsonTimestamp) Assertions.notNull("startAtOperationTime", startAtOperationTime);
        return this;
    }

    @Override // com.mongodb.client.ChangeStreamIterable
    public ChangeStreamIterableImpl<TResult> startAfter(BsonDocument startAfter) {
        this.startAfter = (BsonDocument) Assertions.notNull("startAfter", startAfter);
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable, java.lang.Iterable
    public MongoCursor<ChangeStreamDocument<TResult>> iterator() {
        return cursor();
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
    public MongoChangeStreamCursor<ChangeStreamDocument<TResult>> cursor() {
        return new MongoChangeStreamCursorImpl(execute(), this.codec, initialResumeToken());
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
    @Nullable
    public ChangeStreamDocument<TResult> first() {
        MongoChangeStreamCursor<ChangeStreamDocument<TResult>> cursor = cursor();
        try {
            if (!cursor.hasNext()) {
                return null;
            }
            return cursor.next();
        } finally {
            cursor.close();
        }
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl
    public ReadOperation<BatchCursor<ChangeStreamDocument<TResult>>> asReadOperation() {
        throw new UnsupportedOperationException();
    }

    private ReadOperation<BatchCursor<RawBsonDocument>> createChangeStreamOperation() {
        return new ChangeStreamOperation(this.namespace, this.fullDocument, createBsonDocumentList(this.pipeline), new RawBsonDocumentCodec(), this.changeStreamLevel).batchSize(getBatchSize()).collation(this.collation).maxAwaitTime(this.maxAwaitTimeMS, TimeUnit.MILLISECONDS).resumeAfter(this.resumeToken).startAtOperationTime(this.startAtOperationTime).startAfter(this.startAfter).retryReads(getRetryReads());
    }

    private List<BsonDocument> createBsonDocumentList(List<? extends Bson> pipeline) {
        List<BsonDocument> aggregateList = new ArrayList<>(pipeline.size());
        for (Bson obj : pipeline) {
            if (obj == null) {
                throw new IllegalArgumentException("pipeline cannot contain a null value");
            }
            aggregateList.add(obj.toBsonDocument(BsonDocument.class, this.codecRegistry));
        }
        return aggregateList;
    }

    /* access modifiers changed from: private */
    public BatchCursor<RawBsonDocument> execute() {
        return (BatchCursor) getExecutor().execute(createChangeStreamOperation(), getReadPreference(), getReadConcern(), getClientSession());
    }

    /* access modifiers changed from: private */
    public BsonDocument initialResumeToken() {
        return this.startAfter != null ? this.startAfter : this.resumeToken;
    }
}
