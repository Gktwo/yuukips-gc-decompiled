package com.mongodb;

import com.mongodb.assertions.Assertions;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/AcknowledgedBulkWriteResult.class */
class AcknowledgedBulkWriteResult extends BulkWriteResult {
    private int insertedCount;
    private int matchedCount;
    private int removedCount;
    private int modifiedCount;
    private final List<BulkWriteUpsert> upserts;

    /* access modifiers changed from: package-private */
    public AcknowledgedBulkWriteResult(int insertedCount, int matchedCount, int removedCount, Integer modifiedCount, List<BulkWriteUpsert> upserts) {
        this.insertedCount = insertedCount;
        this.matchedCount = matchedCount;
        this.removedCount = removedCount;
        this.modifiedCount = ((Integer) Assertions.notNull("modifiedCount", modifiedCount)).intValue();
        this.upserts = Collections.unmodifiableList((List) Assertions.notNull("upserts", upserts));
    }

    @Override // com.mongodb.BulkWriteResult
    public boolean isAcknowledged() {
        return true;
    }

    @Override // com.mongodb.BulkWriteResult
    public int getInsertedCount() {
        return this.insertedCount;
    }

    @Override // com.mongodb.BulkWriteResult
    public int getMatchedCount() {
        return this.matchedCount;
    }

    @Override // com.mongodb.BulkWriteResult
    public int getRemovedCount() {
        return this.removedCount;
    }

    @Override // com.mongodb.BulkWriteResult
    public int getModifiedCount() {
        return this.modifiedCount;
    }

    @Override // com.mongodb.BulkWriteResult
    public List<BulkWriteUpsert> getUpserts() {
        return this.upserts;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AcknowledgedBulkWriteResult that = (AcknowledgedBulkWriteResult) o;
        if (this.insertedCount == that.insertedCount && this.matchedCount == that.matchedCount && this.removedCount == that.removedCount && this.modifiedCount == that.modifiedCount && this.upserts.equals(that.upserts)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * this.insertedCount) + this.matchedCount)) + this.removedCount)) + this.modifiedCount)) + this.upserts.hashCode();
    }

    public String toString() {
        return "AcknowledgedBulkWriteResult{insertedCount=" + this.insertedCount + ", matchedCount=" + this.matchedCount + ", removedCount=" + this.removedCount + ", modifiedCount=" + this.modifiedCount + ", upserts=" + this.upserts + '}';
    }
}
