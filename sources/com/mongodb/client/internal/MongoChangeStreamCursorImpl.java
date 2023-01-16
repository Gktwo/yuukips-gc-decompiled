package com.mongodb.client.internal;

import com.mongodb.DBCollection;
import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.client.MongoChangeStreamCursor;
import com.mongodb.internal.operation.AggregateResponseBatchCursor;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.lang.Nullable;
import java.util.List;
import java.util.NoSuchElementException;
import org.bson.BsonDocument;
import org.bson.RawBsonDocument;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/MongoChangeStreamCursorImpl.class */
public class MongoChangeStreamCursorImpl<T> implements MongoChangeStreamCursor<T> {
    private final AggregateResponseBatchCursor<RawBsonDocument> batchCursor;
    private final Decoder<T> decoder;
    private List<RawBsonDocument> curBatch;
    private int curPos;
    private BsonDocument resumeToken;

    public MongoChangeStreamCursorImpl(BatchCursor<RawBsonDocument> batchCursor, Decoder<T> decoder, @Nullable BsonDocument initialResumeToken) {
        this.batchCursor = (AggregateResponseBatchCursor) batchCursor;
        this.decoder = decoder;
        this.resumeToken = initialResumeToken;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cursors do not support removal");
    }

    @Override // com.mongodb.client.MongoCursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.batchCursor.close();
    }

    @Override // com.mongodb.client.MongoCursor, java.util.Iterator
    public boolean hasNext() {
        return this.curBatch != null || this.batchCursor.hasNext();
    }

    @Override // com.mongodb.client.MongoCursor, java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.curBatch == null) {
            this.curBatch = this.batchCursor.next();
        }
        return getNextInBatch();
    }

    @Override // com.mongodb.client.MongoCursor
    @Nullable
    public T tryNext() {
        if (this.curBatch == null) {
            this.curBatch = this.batchCursor.tryNext();
        }
        if (this.curBatch == null && this.batchCursor.getPostBatchResumeToken() != null) {
            this.resumeToken = this.batchCursor.getPostBatchResumeToken();
        }
        if (this.curBatch == null) {
            return null;
        }
        return getNextInBatch();
    }

    @Override // com.mongodb.client.MongoCursor
    @Nullable
    public ServerCursor getServerCursor() {
        return this.batchCursor.getServerCursor();
    }

    @Override // com.mongodb.client.MongoCursor
    public ServerAddress getServerAddress() {
        return this.batchCursor.getServerAddress();
    }

    private T getNextInBatch() {
        RawBsonDocument nextInBatch = this.curBatch.get(this.curPos);
        this.resumeToken = nextInBatch.getDocument(DBCollection.ID_FIELD_NAME);
        if (this.curPos < this.curBatch.size() - 1) {
            this.curPos++;
        } else {
            this.curBatch = null;
            this.curPos = 0;
            if (this.batchCursor.getPostBatchResumeToken() != null) {
                this.resumeToken = this.batchCursor.getPostBatchResumeToken();
            }
        }
        return (T) nextInBatch.decode(this.decoder);
    }

    @Override // com.mongodb.client.MongoChangeStreamCursor
    @Nullable
    public BsonDocument getResumeToken() {
        return this.resumeToken;
    }
}
