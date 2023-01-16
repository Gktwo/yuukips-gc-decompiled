package com.mongodb;

import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/UnacknowledgedBulkWriteResult.class */
class UnacknowledgedBulkWriteResult extends BulkWriteResult {
    @Override // com.mongodb.BulkWriteResult
    public boolean isAcknowledged() {
        return false;
    }

    @Override // com.mongodb.BulkWriteResult
    public int getInsertedCount() {
        throw getUnacknowledgedWriteException();
    }

    @Override // com.mongodb.BulkWriteResult
    public int getMatchedCount() {
        throw getUnacknowledgedWriteException();
    }

    @Override // com.mongodb.BulkWriteResult
    public int getRemovedCount() {
        throw getUnacknowledgedWriteException();
    }

    @Override // com.mongodb.BulkWriteResult
    public int getModifiedCount() {
        throw getUnacknowledgedWriteException();
    }

    @Override // com.mongodb.BulkWriteResult
    public List<BulkWriteUpsert> getUpserts() {
        throw getUnacknowledgedWriteException();
    }

    private UnsupportedOperationException getUnacknowledgedWriteException() {
        return new UnsupportedOperationException("Can not get information about an unacknowledged write");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "UnacknowledgedBulkWriteResult{}";
    }
}
