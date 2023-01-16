package com.mongodb;

import com.mongodb.lang.Nullable;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/BulkWriteException.class */
public class BulkWriteException extends MongoServerException {
    private static final long serialVersionUID = -1505950263354313025L;
    private final BulkWriteResult writeResult;
    private final List<BulkWriteError> writeErrors;
    private final ServerAddress serverAddress;
    private final WriteConcernError writeConcernError;

    /* access modifiers changed from: package-private */
    public BulkWriteException(BulkWriteResult writeResult, List<BulkWriteError> writeErrors, @Nullable WriteConcernError writeConcernError, ServerAddress serverAddress) {
        super("Bulk write operation error on server " + serverAddress + ". " + (writeErrors.isEmpty() ? "" : "Write errors: " + writeErrors + ". ") + (writeConcernError == null ? "" : "Write concern error: " + writeConcernError + ". "), serverAddress);
        this.writeResult = writeResult;
        this.writeErrors = writeErrors;
        this.writeConcernError = writeConcernError;
        this.serverAddress = serverAddress;
    }

    public BulkWriteResult getWriteResult() {
        return this.writeResult;
    }

    public List<BulkWriteError> getWriteErrors() {
        return this.writeErrors;
    }

    @Nullable
    public WriteConcernError getWriteConcernError() {
        return this.writeConcernError;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BulkWriteException that = (BulkWriteException) o;
        if (!this.writeErrors.equals(that.writeErrors) || !this.serverAddress.equals(that.serverAddress)) {
            return false;
        }
        if (this.writeConcernError != null) {
            if (!this.writeConcernError.equals(that.writeConcernError)) {
                return false;
            }
        } else if (that.writeConcernError != null) {
            return false;
        }
        if (!this.writeResult.equals(that.writeResult)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((31 * ((31 * this.writeResult.hashCode()) + this.writeErrors.hashCode())) + this.serverAddress.hashCode())) + (this.writeConcernError != null ? this.writeConcernError.hashCode() : 0);
    }
}
