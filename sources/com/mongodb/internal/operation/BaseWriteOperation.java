package com.mongodb.internal.operation;

import com.mongodb.DuplicateKeyException;
import com.mongodb.ErrorCategory;
import com.mongodb.MongoBulkWriteException;
import com.mongodb.MongoException;
import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.WriteConcernException;
import com.mongodb.WriteConcernResult;
import com.mongodb.assertions.Assertions;
import com.mongodb.bulk.BulkWriteError;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.bulk.WriteConcernError;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.bulk.WriteRequest;
import java.util.List;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/BaseWriteOperation.class */
public abstract class BaseWriteOperation implements AsyncWriteOperation<WriteConcernResult>, WriteOperation<WriteConcernResult> {
    private final WriteConcern writeConcern;
    private final MongoNamespace namespace;
    private final boolean ordered;
    private final boolean retryWrites;
    private Boolean bypassDocumentValidation;

    protected abstract List<? extends WriteRequest> getWriteRequests();

    protected abstract WriteRequest.Type getType();

    public BaseWriteOperation(MongoNamespace namespace, boolean ordered, WriteConcern writeConcern) {
        this(namespace, ordered, writeConcern, false);
    }

    public BaseWriteOperation(MongoNamespace namespace, boolean ordered, WriteConcern writeConcern, boolean retryWrites) {
        this.ordered = ordered;
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.writeConcern = (WriteConcern) Assertions.notNull("writeConcern", writeConcern);
        this.retryWrites = retryWrites;
    }

    public MongoNamespace getNamespace() {
        return this.namespace;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public boolean isOrdered() {
        return this.ordered;
    }

    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public BaseWriteOperation bypassDocumentValidation(Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public WriteConcernResult execute(WriteBinding binding) {
        try {
            BulkWriteResult result = getMixedBulkOperation().execute(binding);
            if (result.wasAcknowledged()) {
                return translateBulkWriteResult(result);
            }
            return WriteConcernResult.unacknowledged();
        } catch (MongoBulkWriteException e) {
            throw convertBulkWriteException(e);
        }
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(AsyncWriteBinding binding, final SingleResultCallback<WriteConcernResult> callback) {
        getMixedBulkOperation().executeAsync(binding, new SingleResultCallback<BulkWriteResult>() { // from class: com.mongodb.internal.operation.BaseWriteOperation.1
            public void onResult(BulkWriteResult result, Throwable t) {
                if (t != null) {
                    if (t instanceof MongoBulkWriteException) {
                        callback.onResult(null, BaseWriteOperation.this.convertBulkWriteException((MongoBulkWriteException) t));
                    } else {
                        callback.onResult(null, t);
                    }
                } else if (result.wasAcknowledged()) {
                    callback.onResult(BaseWriteOperation.this.translateBulkWriteResult(result), null);
                } else {
                    callback.onResult(WriteConcernResult.unacknowledged(), null);
                }
            }
        });
    }

    private MixedBulkWriteOperation getMixedBulkOperation() {
        return new MixedBulkWriteOperation(this.namespace, getWriteRequests(), this.ordered, this.writeConcern, this.retryWrites).bypassDocumentValidation(this.bypassDocumentValidation);
    }

    /* access modifiers changed from: private */
    public MongoException convertBulkWriteException(MongoBulkWriteException e) {
        BulkWriteError lastError = getLastError(e);
        if (lastError == null) {
            return new WriteConcernException(manufactureGetLastErrorResponse(e), e.getServerAddress(), translateBulkWriteResult(e.getWriteResult()));
        }
        if (ErrorCategory.fromErrorCode(lastError.getCode()) == ErrorCategory.DUPLICATE_KEY) {
            return new DuplicateKeyException(manufactureGetLastErrorResponse(e), e.getServerAddress(), translateBulkWriteResult(e.getWriteResult()));
        }
        return new WriteConcernException(manufactureGetLastErrorResponse(e), e.getServerAddress(), translateBulkWriteResult(e.getWriteResult()));
    }

    private BsonDocument manufactureGetLastErrorResponse(MongoBulkWriteException e) {
        BsonDocument response = new BsonDocument();
        addBulkWriteResultToResponse(e.getWriteResult(), response);
        WriteConcernError writeConcernError = e.getWriteConcernError();
        if (writeConcernError != null) {
            response.putAll(writeConcernError.getDetails());
        }
        BulkWriteError lastError = getLastError(e);
        if (lastError != null) {
            response.put("err", (BsonValue) new BsonString(lastError.getMessage()));
            response.put("code", (BsonValue) new BsonInt32(lastError.getCode()));
            response.putAll(lastError.getDetails());
        } else if (writeConcernError != null) {
            response.put("err", (BsonValue) new BsonString(writeConcernError.getMessage()));
            response.put("code", (BsonValue) new BsonInt32(writeConcernError.getCode()));
        }
        return response;
    }

    private void addBulkWriteResultToResponse(BulkWriteResult bulkWriteResult, BsonDocument response) {
        response.put("ok", (BsonValue) new BsonInt32(1));
        if (getType() == WriteRequest.Type.INSERT) {
            response.put("n", (BsonValue) new BsonInt32(0));
        } else if (getType() == WriteRequest.Type.DELETE) {
            response.put("n", (BsonValue) new BsonInt32(bulkWriteResult.getDeletedCount()));
        } else if (getType() == WriteRequest.Type.UPDATE || getType() == WriteRequest.Type.REPLACE) {
            response.put("n", (BsonValue) new BsonInt32(bulkWriteResult.getMatchedCount() + bulkWriteResult.getUpserts().size()));
            if (bulkWriteResult.getUpserts().isEmpty()) {
                response.put("updatedExisting", (BsonValue) BsonBoolean.TRUE);
                return;
            }
            response.put("updatedExisting", (BsonValue) BsonBoolean.FALSE);
            response.put("upserted", bulkWriteResult.getUpserts().get(0).getId());
        }
    }

    /* access modifiers changed from: private */
    public WriteConcernResult translateBulkWriteResult(BulkWriteResult bulkWriteResult) {
        return WriteConcernResult.acknowledged(getCount(bulkWriteResult), getUpdatedExisting(bulkWriteResult), bulkWriteResult.getUpserts().isEmpty() ? null : bulkWriteResult.getUpserts().get(0).getId());
    }

    private int getCount(BulkWriteResult bulkWriteResult) {
        int count = 0;
        if (getType() == WriteRequest.Type.UPDATE || getType() == WriteRequest.Type.REPLACE) {
            count = bulkWriteResult.getMatchedCount() + bulkWriteResult.getUpserts().size();
        } else if (getType() == WriteRequest.Type.DELETE) {
            count = bulkWriteResult.getDeletedCount();
        }
        return count;
    }

    private boolean getUpdatedExisting(BulkWriteResult bulkWriteResult) {
        return getType() == WriteRequest.Type.UPDATE && bulkWriteResult.getMatchedCount() > 0;
    }

    private BulkWriteError getLastError(MongoBulkWriteException e) {
        if (e.getWriteErrors().isEmpty()) {
            return null;
        }
        return e.getWriteErrors().get(e.getWriteErrors().size() - 1);
    }
}
