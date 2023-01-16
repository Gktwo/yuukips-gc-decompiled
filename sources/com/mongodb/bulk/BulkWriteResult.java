package com.mongodb.bulk;

import com.mongodb.internal.bulk.WriteRequest;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/bulk/BulkWriteResult.class */
public abstract class BulkWriteResult {
    public abstract boolean wasAcknowledged();

    public abstract int getInsertedCount();

    public abstract int getMatchedCount();

    public abstract int getDeletedCount();

    public abstract int getModifiedCount();

    public abstract List<BulkWriteInsert> getInserts();

    public abstract List<BulkWriteUpsert> getUpserts();

    @Deprecated
    public static BulkWriteResult acknowledged(WriteRequest.Type type, int count, List<BulkWriteUpsert> upserts) {
        return acknowledged(type, count, (Integer) 0, upserts, (List<BulkWriteInsert>) Collections.emptyList());
    }

    @Deprecated
    public static BulkWriteResult acknowledged(WriteRequest.Type type, int count, Integer modifiedCount, List<BulkWriteUpsert> upserts) {
        return acknowledged(type, count, modifiedCount, upserts, Collections.emptyList());
    }

    public static BulkWriteResult acknowledged(WriteRequest.Type type, int count, Integer modifiedCount, List<BulkWriteUpsert> upserts, List<BulkWriteInsert> inserts) {
        return acknowledged(type == WriteRequest.Type.INSERT ? count : 0, (type == WriteRequest.Type.UPDATE || type == WriteRequest.Type.REPLACE) ? count : 0, type == WriteRequest.Type.DELETE ? count : 0, modifiedCount, upserts, inserts);
    }

    @Deprecated
    public static BulkWriteResult acknowledged(int insertedCount, int matchedCount, int removedCount, Integer modifiedCount, List<BulkWriteUpsert> upserts) {
        return acknowledged(insertedCount, matchedCount, removedCount, modifiedCount, upserts, Collections.emptyList());
    }

    public static BulkWriteResult acknowledged(final int insertedCount, final int matchedCount, final int removedCount, final Integer modifiedCount, final List<BulkWriteUpsert> upserts, final List<BulkWriteInsert> inserts) {
        return new BulkWriteResult() { // from class: com.mongodb.bulk.BulkWriteResult.1
            @Override // com.mongodb.bulk.BulkWriteResult
            public boolean wasAcknowledged() {
                return true;
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public int getInsertedCount() {
                return insertedCount;
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public int getMatchedCount() {
                return matchedCount;
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public int getDeletedCount() {
                return removedCount;
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public int getModifiedCount() {
                return modifiedCount.intValue();
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public List<BulkWriteInsert> getInserts() {
                return Collections.unmodifiableList(inserts);
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public List<BulkWriteUpsert> getUpserts() {
                return Collections.unmodifiableList(upserts);
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                BulkWriteResult that = (BulkWriteResult) o;
                if (!that.wasAcknowledged() || insertedCount != that.getInsertedCount()) {
                    return false;
                }
                if ((modifiedCount == null || modifiedCount.equals(Integer.valueOf(that.getModifiedCount()))) && removedCount == that.getDeletedCount() && matchedCount == that.getMatchedCount() && upserts.equals(that.getUpserts()) && inserts.equals(that.getInserts())) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return (31 * ((31 * ((31 * ((31 * ((31 * upserts.hashCode()) + inserts.hashCode())) + insertedCount)) + matchedCount)) + removedCount)) + (modifiedCount != null ? modifiedCount.hashCode() : 0);
            }

            public String toString() {
                return "AcknowledgedBulkWriteResult{insertedCount=" + insertedCount + ", matchedCount=" + matchedCount + ", removedCount=" + removedCount + ", modifiedCount=" + modifiedCount + ", upserts=" + upserts + ", inserts=" + inserts + '}';
            }
        };
    }

    public static BulkWriteResult unacknowledged() {
        return new BulkWriteResult() { // from class: com.mongodb.bulk.BulkWriteResult.2
            @Override // com.mongodb.bulk.BulkWriteResult
            public boolean wasAcknowledged() {
                return false;
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public int getInsertedCount() {
                throw getUnacknowledgedWriteException();
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public int getMatchedCount() {
                throw getUnacknowledgedWriteException();
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public int getDeletedCount() {
                throw getUnacknowledgedWriteException();
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public int getModifiedCount() {
                throw getUnacknowledgedWriteException();
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public List<BulkWriteInsert> getInserts() {
                throw getUnacknowledgedWriteException();
            }

            @Override // com.mongodb.bulk.BulkWriteResult
            public List<BulkWriteUpsert> getUpserts() {
                throw getUnacknowledgedWriteException();
            }

            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                return o != null && getClass() == o.getClass() && !((BulkWriteResult) o).wasAcknowledged();
            }

            public int hashCode() {
                return 0;
            }

            public String toString() {
                return "UnacknowledgedBulkWriteResult{}";
            }

            private UnsupportedOperationException getUnacknowledgedWriteException() {
                return new UnsupportedOperationException("Cannot get information about an unacknowledged write");
            }
        };
    }
}
