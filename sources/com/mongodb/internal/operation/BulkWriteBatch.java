package com.mongodb.internal.operation;

import com.mongodb.DBCollection;
import com.mongodb.MongoBulkWriteException;
import com.mongodb.MongoClientException;
import com.mongodb.MongoInternalException;
import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.bulk.BulkWriteError;
import com.mongodb.bulk.BulkWriteInsert;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.bulk.BulkWriteUpsert;
import com.mongodb.bulk.WriteConcernError;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.bulk.WriteRequest;
import com.mongodb.internal.bulk.WriteRequestWithIndex;
import com.mongodb.internal.connection.BulkWriteBatchCombiner;
import com.mongodb.internal.connection.IndexMap;
import com.mongodb.internal.connection.SplittablePayload;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.internal.validator.CollectibleDocumentFieldNameValidator;
import com.mongodb.internal.validator.MappedFieldNameValidator;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import com.mongodb.internal.validator.UpdateFieldNameValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.bson.BsonArray;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.FieldNameValidator;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.Decoder;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/BulkWriteBatch.class */
public final class BulkWriteBatch {
    private static final CodecRegistry REGISTRY = CodecRegistries.fromProviders(new BsonValueCodecProvider());
    private static final Decoder<BsonDocument> DECODER = REGISTRY.get(BsonDocument.class);
    private static final FieldNameValidator NO_OP_FIELD_NAME_VALIDATOR = new NoOpFieldNameValidator();
    private final MongoNamespace namespace;
    private final ConnectionDescription connectionDescription;
    private final boolean ordered;
    private final WriteConcern writeConcern;
    private final Boolean bypassDocumentValidation;
    private final boolean retryWrites;
    private final BulkWriteBatchCombiner bulkWriteBatchCombiner;
    private final IndexMap indexMap;
    private final WriteRequest.Type batchType;
    private final BsonDocument command;
    private final SplittablePayload payload;
    private final List<WriteRequestWithIndex> unprocessed;
    private final SessionContext sessionContext;

    public static BulkWriteBatch createBulkWriteBatch(MongoNamespace namespace, ServerDescription serverDescription, ConnectionDescription connectionDescription, boolean ordered, WriteConcern writeConcern, Boolean bypassDocumentValidation, boolean retryWrites, List<? extends WriteRequest> writeRequests, SessionContext sessionContext) {
        if (!sessionContext.hasSession() || sessionContext.isImplicitSession() || sessionContext.hasActiveTransaction() || writeConcern.isAcknowledged()) {
            boolean canRetryWrites = OperationHelper.isRetryableWrite(retryWrites, writeConcern, serverDescription, connectionDescription, sessionContext);
            List<WriteRequestWithIndex> writeRequestsWithIndex = new ArrayList<>();
            boolean writeRequestsAreRetryable = true;
            for (int i = 0; i < writeRequests.size(); i++) {
                WriteRequest writeRequest = (WriteRequest) writeRequests.get(i);
                writeRequestsAreRetryable = writeRequestsAreRetryable && isRetryable(writeRequest);
                writeRequestsWithIndex.add(new WriteRequestWithIndex(writeRequest, i));
            }
            if (canRetryWrites && !writeRequestsAreRetryable) {
                canRetryWrites = false;
                OperationHelper.LOGGER.debug("retryWrites set but one or more writeRequests do not support retryable writes");
            }
            return new BulkWriteBatch(namespace, connectionDescription, ordered, writeConcern, bypassDocumentValidation, canRetryWrites, new BulkWriteBatchCombiner(connectionDescription.getServerAddress(), ordered, writeConcern), writeRequestsWithIndex, sessionContext);
        }
        throw new MongoClientException("Unacknowledged writes are not supported when using an explicit session");
    }

    private BulkWriteBatch(MongoNamespace namespace, ConnectionDescription connectionDescription, boolean ordered, WriteConcern writeConcern, Boolean bypassDocumentValidation, boolean retryWrites, BulkWriteBatchCombiner bulkWriteBatchCombiner, List<WriteRequestWithIndex> writeRequestsWithIndices, SessionContext sessionContext) {
        this.namespace = namespace;
        this.connectionDescription = connectionDescription;
        this.ordered = ordered;
        this.writeConcern = writeConcern;
        this.bypassDocumentValidation = bypassDocumentValidation;
        this.bulkWriteBatchCombiner = bulkWriteBatchCombiner;
        this.batchType = writeRequestsWithIndices.isEmpty() ? WriteRequest.Type.INSERT : writeRequestsWithIndices.get(0).getType();
        this.retryWrites = retryWrites;
        List<WriteRequestWithIndex> payloadItems = new ArrayList<>();
        List<WriteRequestWithIndex> unprocessedItems = new ArrayList<>();
        IndexMap indexMap = IndexMap.create();
        int i = 0;
        while (true) {
            if (i >= writeRequestsWithIndices.size()) {
                break;
            }
            WriteRequestWithIndex writeRequestWithIndex = writeRequestsWithIndices.get(i);
            if (writeRequestWithIndex.getType() == this.batchType) {
                indexMap = indexMap.add(payloadItems.size(), writeRequestWithIndex.getIndex());
                payloadItems.add(writeRequestWithIndex);
            } else if (ordered) {
                unprocessedItems.addAll(writeRequestsWithIndices.subList(i, writeRequestsWithIndices.size()));
                break;
            } else {
                unprocessedItems.add(writeRequestWithIndex);
            }
            i++;
        }
        this.indexMap = indexMap;
        this.unprocessed = unprocessedItems;
        this.payload = new SplittablePayload(getPayloadType(this.batchType), payloadItems);
        this.sessionContext = sessionContext;
        this.command = new BsonDocument();
        if (!payloadItems.isEmpty()) {
            this.command.put(getCommandName(this.batchType), (BsonValue) new BsonString(namespace.getCollectionName()));
            this.command.put("ordered", (BsonValue) new BsonBoolean(ordered));
            if (!writeConcern.isServerDefault() && !sessionContext.hasActiveTransaction()) {
                this.command.put("writeConcern", (BsonValue) writeConcern.asDocument());
            }
            if (bypassDocumentValidation != null) {
                this.command.put("bypassDocumentValidation", (BsonValue) new BsonBoolean(bypassDocumentValidation.booleanValue()));
            }
            if (retryWrites) {
                this.command.put("txnNumber", (BsonValue) new BsonInt64(sessionContext.advanceTransactionNumber()));
            }
        }
    }

    private BulkWriteBatch(MongoNamespace namespace, ConnectionDescription connectionDescription, boolean ordered, WriteConcern writeConcern, Boolean bypassDocumentValidation, boolean retryWrites, BulkWriteBatchCombiner bulkWriteBatchCombiner, IndexMap indexMap, WriteRequest.Type batchType, BsonDocument command, SplittablePayload payload, List<WriteRequestWithIndex> unprocessed, SessionContext sessionContext) {
        this.namespace = namespace;
        this.connectionDescription = connectionDescription;
        this.ordered = ordered;
        this.writeConcern = writeConcern;
        this.bypassDocumentValidation = bypassDocumentValidation;
        this.bulkWriteBatchCombiner = bulkWriteBatchCombiner;
        this.indexMap = indexMap;
        this.batchType = batchType;
        this.payload = payload;
        this.unprocessed = unprocessed;
        this.retryWrites = retryWrites;
        this.sessionContext = sessionContext;
        if (retryWrites) {
            command.put("txnNumber", (BsonValue) new BsonInt64(sessionContext.advanceTransactionNumber()));
        }
        this.command = command;
    }

    public void addResult(BsonDocument result) {
        if (!this.writeConcern.isAcknowledged()) {
            return;
        }
        if (hasError(result)) {
            this.bulkWriteBatchCombiner.addErrorResult(getBulkWriteException(result), this.indexMap);
            return;
        }
        this.bulkWriteBatchCombiner.addResult(getBulkWriteResult(result));
    }

    public boolean getRetryWrites() {
        return this.retryWrites;
    }

    public BsonDocument getCommand() {
        return this.command;
    }

    public SplittablePayload getPayload() {
        return this.payload;
    }

    public Decoder<BsonDocument> getDecoder() {
        return DECODER;
    }

    public BulkWriteResult getResult() {
        return this.bulkWriteBatchCombiner.getResult();
    }

    public boolean hasErrors() {
        return this.bulkWriteBatchCombiner.hasErrors();
    }

    public MongoBulkWriteException getError() {
        return this.bulkWriteBatchCombiner.getError();
    }

    public boolean shouldProcessBatch() {
        return !this.bulkWriteBatchCombiner.shouldStopSendingMoreBatches() && !this.payload.isEmpty();
    }

    public boolean hasAnotherBatch() {
        return !this.unprocessed.isEmpty();
    }

    public BulkWriteBatch getNextBatch() {
        if (!this.payload.hasAnotherSplit()) {
            return new BulkWriteBatch(this.namespace, this.connectionDescription, this.ordered, this.writeConcern, this.bypassDocumentValidation, this.retryWrites, this.bulkWriteBatchCombiner, this.unprocessed, this.sessionContext);
        }
        IndexMap nextIndexMap = IndexMap.create();
        int newIndex = 0;
        for (int i = this.payload.getPosition(); i < this.payload.size(); i++) {
            nextIndexMap = nextIndexMap.add(newIndex, this.indexMap.map(i));
            newIndex++;
        }
        return new BulkWriteBatch(this.namespace, this.connectionDescription, this.ordered, this.writeConcern, this.bypassDocumentValidation, this.retryWrites, this.bulkWriteBatchCombiner, nextIndexMap, this.batchType, this.command, this.payload.getNextSplit(), this.unprocessed, this.sessionContext);
    }

    public FieldNameValidator getFieldNameValidator() {
        if (this.batchType == WriteRequest.Type.INSERT) {
            return new CollectibleDocumentFieldNameValidator();
        }
        if (this.batchType != WriteRequest.Type.UPDATE && this.batchType != WriteRequest.Type.REPLACE) {
            return NO_OP_FIELD_NAME_VALIDATOR;
        }
        Map<String, FieldNameValidator> rootMap = new HashMap<>();
        if (this.batchType == WriteRequest.Type.REPLACE) {
            rootMap.put("u", new CollectibleDocumentFieldNameValidator());
        } else {
            rootMap.put("u", new UpdateFieldNameValidator());
        }
        return new MappedFieldNameValidator(NO_OP_FIELD_NAME_VALIDATOR, rootMap);
    }

    private BulkWriteResult getBulkWriteResult(BsonDocument result) {
        int count = result.getNumber("n").intValue();
        List<BulkWriteInsert> insertedItems = getInsertedItems(result);
        List<BulkWriteUpsert> upsertedItems = getUpsertedItems(result);
        return BulkWriteResult.acknowledged(this.batchType, count - upsertedItems.size(), getModifiedCount(result), upsertedItems, insertedItems);
    }

    private List<BulkWriteInsert> getInsertedItems(BsonDocument result) {
        if (this.payload.getPayloadType() != SplittablePayload.Type.INSERT) {
            return Collections.emptyList();
        }
        Stream<WriteRequestWithIndex> writeRequests = this.payload.getWriteRequestWithIndexes().stream();
        List<Integer> writeErrors = (List) getWriteErrors(result).stream().map((v0) -> {
            return v0.getIndex();
        }).collect(Collectors.toList());
        if (!writeErrors.isEmpty()) {
            writeRequests = writeRequests.filter(wr -> {
                return !writeErrors.contains(Integer.valueOf(wr.getIndex()));
            });
        }
        if (this.payload.getPosition() < this.payload.size()) {
            writeRequests = writeRequests.filter(wr -> {
                return wr.getIndex() < this.payload.getPosition();
            });
        }
        return (List) writeRequests.map(wr -> {
            return new BulkWriteInsert(wr.getIndex(), this.payload.getInsertedIds().get(Integer.valueOf(wr.getIndex())));
        }).collect(Collectors.toList());
    }

    private List<BulkWriteUpsert> getUpsertedItems(BsonDocument result) {
        BsonArray upsertedValue = result.getArray("upserted", new BsonArray());
        List<BulkWriteUpsert> bulkWriteUpsertList = new ArrayList<>();
        Iterator<BsonValue> it = upsertedValue.iterator();
        while (it.hasNext()) {
            BsonDocument upsertedItemDocument = (BsonDocument) it.next();
            bulkWriteUpsertList.add(new BulkWriteUpsert(this.indexMap.map(upsertedItemDocument.getNumber("index").intValue()), upsertedItemDocument.get((Object) DBCollection.ID_FIELD_NAME)));
        }
        return bulkWriteUpsertList;
    }

    private Integer getModifiedCount(BsonDocument result) {
        return Integer.valueOf(result.getNumber("nModified", new BsonInt32(0)).intValue());
    }

    private boolean hasError(BsonDocument result) {
        return (result.get("writeErrors") == null && result.get("writeConcernError") == null) ? false : true;
    }

    private MongoBulkWriteException getBulkWriteException(BsonDocument result) {
        if (hasError(result)) {
            return new MongoBulkWriteException(getBulkWriteResult(result), getWriteErrors(result), getWriteConcernError(result), this.connectionDescription.getServerAddress(), (Set) result.getArray("errorLabels", new BsonArray()).stream().map(i -> {
                return i.asString().getValue();
            }).collect(Collectors.toSet()));
        }
        throw new MongoInternalException("This method should not have been called");
    }

    private List<BulkWriteError> getWriteErrors(BsonDocument result) {
        List<BulkWriteError> writeErrors = new ArrayList<>();
        BsonArray writeErrorsDocuments = (BsonArray) result.get("writeErrors");
        if (writeErrorsDocuments != null) {
            Iterator<BsonValue> it = writeErrorsDocuments.iterator();
            while (it.hasNext()) {
                BsonDocument curDocument = (BsonDocument) it.next();
                writeErrors.add(new BulkWriteError(curDocument.getNumber("code").intValue(), curDocument.getString("errmsg").getValue(), curDocument.getDocument("errInfo", new BsonDocument()), curDocument.getNumber("index").intValue()));
            }
        }
        return writeErrors;
    }

    private WriteConcernError getWriteConcernError(BsonDocument result) {
        BsonDocument writeConcernErrorDocument = (BsonDocument) result.get("writeConcernError");
        if (writeConcernErrorDocument == null) {
            return null;
        }
        return WriteConcernHelper.createWriteConcernError(writeConcernErrorDocument);
    }

    private String getCommandName(WriteRequest.Type batchType) {
        if (batchType == WriteRequest.Type.INSERT) {
            return "insert";
        }
        if (batchType == WriteRequest.Type.UPDATE || batchType == WriteRequest.Type.REPLACE) {
            return "update";
        }
        return "delete";
    }

    private SplittablePayload.Type getPayloadType(WriteRequest.Type batchType) {
        if (batchType == WriteRequest.Type.INSERT) {
            return SplittablePayload.Type.INSERT;
        }
        if (batchType == WriteRequest.Type.UPDATE) {
            return SplittablePayload.Type.UPDATE;
        }
        if (batchType == WriteRequest.Type.REPLACE) {
            return SplittablePayload.Type.REPLACE;
        }
        return SplittablePayload.Type.DELETE;
    }

    private static boolean isRetryable(WriteRequest writeRequest) {
        return (writeRequest.getType() == WriteRequest.Type.UPDATE || writeRequest.getType() == WriteRequest.Type.REPLACE) ? !((UpdateRequest) writeRequest).isMulti() : writeRequest.getType() != WriteRequest.Type.DELETE || !((DeleteRequest) writeRequest).isMulti();
    }
}
