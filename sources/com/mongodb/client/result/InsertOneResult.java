package com.mongodb.client.result;

import com.mongodb.lang.Nullable;
import java.util.Objects;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/client/result/InsertOneResult.class */
public abstract class InsertOneResult {
    public abstract boolean wasAcknowledged();

    @Nullable
    public abstract BsonValue getInsertedId();

    public static InsertOneResult acknowledged(@Nullable BsonValue insertId) {
        return new AcknowledgedInsertOneResult(insertId);
    }

    public static InsertOneResult unacknowledged() {
        return new UnacknowledgedInsertOneResult();
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/result/InsertOneResult$AcknowledgedInsertOneResult.class */
    private static class AcknowledgedInsertOneResult extends InsertOneResult {
        private final BsonValue insertedId;

        AcknowledgedInsertOneResult(@Nullable BsonValue insertId) {
            this.insertedId = insertId;
        }

        @Override // com.mongodb.client.result.InsertOneResult
        public boolean wasAcknowledged() {
            return true;
        }

        @Override // com.mongodb.client.result.InsertOneResult
        @Nullable
        public BsonValue getInsertedId() {
            return this.insertedId;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return Objects.equals(this.insertedId, ((AcknowledgedInsertOneResult) o).insertedId);
        }

        public int hashCode() {
            return Objects.hash(this.insertedId);
        }

        public String toString() {
            return "AcknowledgedInsertOneResult{insertedId=" + this.insertedId + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/result/InsertOneResult$UnacknowledgedInsertOneResult.class */
    private static class UnacknowledgedInsertOneResult extends InsertOneResult {
        private UnacknowledgedInsertOneResult() {
        }

        @Override // com.mongodb.client.result.InsertOneResult
        public boolean wasAcknowledged() {
            return false;
        }

        @Override // com.mongodb.client.result.InsertOneResult
        @Nullable
        public BsonValue getInsertedId() {
            throw new UnsupportedOperationException("Cannot get information about an unacknowledged insert");
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
            return "UnacknowledgedInsertOneResult{}";
        }
    }
}
