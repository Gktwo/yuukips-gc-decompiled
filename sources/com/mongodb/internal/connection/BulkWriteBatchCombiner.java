package com.mongodb.internal.connection;

import com.mongodb.MongoBulkWriteException;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.bulk.BulkWriteError;
import com.mongodb.bulk.BulkWriteInsert;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.bulk.BulkWriteUpsert;
import com.mongodb.bulk.WriteConcernError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/BulkWriteBatchCombiner.class */
public class BulkWriteBatchCombiner {
    private final ServerAddress serverAddress;
    private final boolean ordered;
    private final WriteConcern writeConcern;
    private int insertedCount;
    private int matchedCount;
    private int deletedCount;
    private int modifiedCount = 0;
    private final Set<BulkWriteUpsert> writeUpserts = new TreeSet(Comparator.comparingInt((v0) -> {
        return v0.getIndex();
    }));
    private final Set<BulkWriteInsert> writeInserts = new TreeSet(Comparator.comparingInt((v0) -> {
        return v0.getIndex();
    }));
    private final Set<BulkWriteError> writeErrors = new TreeSet(Comparator.comparingInt((v0) -> {
        return v0.getIndex();
    }));
    private final Set<String> errorLabels = new HashSet();
    private final List<WriteConcernError> writeConcernErrors = new ArrayList();

    public BulkWriteBatchCombiner(ServerAddress serverAddress, boolean ordered, WriteConcern writeConcern) {
        this.writeConcern = (WriteConcern) Assertions.notNull("writeConcern", writeConcern);
        this.ordered = ordered;
        this.serverAddress = (ServerAddress) Assertions.notNull("serverAddress", serverAddress);
    }

    public void addResult(BulkWriteResult result) {
        this.insertedCount += result.getInsertedCount();
        this.matchedCount += result.getMatchedCount();
        this.deletedCount += result.getDeletedCount();
        this.modifiedCount += result.getModifiedCount();
        this.writeUpserts.addAll(result.getUpserts());
        this.writeInserts.addAll(result.getInserts());
    }

    public void addErrorResult(MongoBulkWriteException exception, IndexMap indexMap) {
        addResult(exception.getWriteResult());
        this.errorLabels.addAll(exception.getErrorLabels());
        mergeWriteErrors(exception.getWriteErrors(), indexMap);
        mergeWriteConcernError(exception.getWriteConcernError());
    }

    public void addWriteErrorResult(BulkWriteError writeError, IndexMap indexMap) {
        Assertions.notNull("writeError", writeError);
        mergeWriteErrors(Collections.singletonList(writeError), indexMap);
    }

    public void addWriteConcernErrorResult(WriteConcernError writeConcernError) {
        Assertions.notNull("writeConcernError", writeConcernError);
        mergeWriteConcernError(writeConcernError);
    }

    public void addErrorResult(List<BulkWriteError> writeErrors, WriteConcernError writeConcernError, IndexMap indexMap) {
        mergeWriteErrors(writeErrors, indexMap);
        mergeWriteConcernError(writeConcernError);
    }

    public BulkWriteResult getResult() {
        throwOnError();
        return createResult();
    }

    public boolean shouldStopSendingMoreBatches() {
        return this.ordered && hasWriteErrors();
    }

    public boolean hasErrors() {
        return hasWriteErrors() || hasWriteConcernErrors();
    }

    public MongoBulkWriteException getError() {
        if (!hasErrors()) {
            return null;
        }
        return new MongoBulkWriteException(createResult(), new ArrayList(this.writeErrors), this.writeConcernErrors.isEmpty() ? null : this.writeConcernErrors.get(this.writeConcernErrors.size() - 1), this.serverAddress, this.errorLabels);
    }

    private void mergeWriteConcernError(WriteConcernError writeConcernError) {
        if (writeConcernError == null) {
            return;
        }
        if (this.writeConcernErrors.isEmpty()) {
            this.writeConcernErrors.add(writeConcernError);
            this.errorLabels.addAll(writeConcernError.getErrorLabels());
        } else if (!writeConcernError.equals(this.writeConcernErrors.get(this.writeConcernErrors.size() - 1))) {
            this.writeConcernErrors.add(writeConcernError);
            this.errorLabels.addAll(writeConcernError.getErrorLabels());
        }
    }

    private void mergeWriteErrors(List<BulkWriteError> newWriteErrors, IndexMap indexMap) {
        for (BulkWriteError cur : newWriteErrors) {
            this.writeErrors.add(new BulkWriteError(cur.getCode(), cur.getMessage(), cur.getDetails(), indexMap.map(cur.getIndex())));
        }
    }

    private void throwOnError() {
        if (hasErrors()) {
            throw getError();
        }
    }

    private BulkWriteResult createResult() {
        if (this.writeConcern.isAcknowledged()) {
            return BulkWriteResult.acknowledged(this.insertedCount, this.matchedCount, this.deletedCount, Integer.valueOf(this.modifiedCount), new ArrayList(this.writeUpserts), new ArrayList(this.writeInserts));
        }
        return BulkWriteResult.unacknowledged();
    }

    private boolean hasWriteErrors() {
        return !this.writeErrors.isEmpty();
    }

    private boolean hasWriteConcernErrors() {
        return !this.writeConcernErrors.isEmpty();
    }
}
