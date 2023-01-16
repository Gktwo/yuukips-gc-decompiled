package com.mongodb.client.result;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/client/result/InsertManyResult.class */
public abstract class InsertManyResult {
    public abstract boolean wasAcknowledged();

    public abstract Map<Integer, BsonValue> getInsertedIds();

    public static InsertManyResult acknowledged(Map<Integer, BsonValue> insertedIds) {
        return new AcknowledgedInsertManyResult(insertedIds);
    }

    public static InsertManyResult unacknowledged() {
        return new UnacknowledgedInsertManyResult();
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/result/InsertManyResult$AcknowledgedInsertManyResult.class */
    private static class AcknowledgedInsertManyResult extends InsertManyResult {
        private final Map<Integer, BsonValue> insertedIds;

        AcknowledgedInsertManyResult(Map<Integer, BsonValue> insertedIds) {
            this.insertedIds = Collections.unmodifiableMap(new HashMap(insertedIds));
        }

        @Override // com.mongodb.client.result.InsertManyResult
        public boolean wasAcknowledged() {
            return true;
        }

        @Override // com.mongodb.client.result.InsertManyResult
        public Map<Integer, BsonValue> getInsertedIds() {
            return this.insertedIds;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return Objects.equals(this.insertedIds, ((AcknowledgedInsertManyResult) o).insertedIds);
        }

        public int hashCode() {
            return Objects.hash(this.insertedIds);
        }

        public String toString() {
            return "AcknowledgedInsertManyResult{insertedIds=" + this.insertedIds + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/result/InsertManyResult$UnacknowledgedInsertManyResult.class */
    private static class UnacknowledgedInsertManyResult extends InsertManyResult {
        private UnacknowledgedInsertManyResult() {
        }

        @Override // com.mongodb.client.result.InsertManyResult
        public boolean wasAcknowledged() {
            return false;
        }

        @Override // com.mongodb.client.result.InsertManyResult
        public Map<Integer, BsonValue> getInsertedIds() {
            throw new UnsupportedOperationException("Cannot get information about an unacknowledged insert many");
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
            return "UnacknowledgedInsertManyResult{}";
        }
    }
}
