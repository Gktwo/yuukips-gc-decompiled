package com.mongodb;

import com.mongodb.bulk.BulkWriteError;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.bulk.WriteConcernError;
import com.mongodb.lang.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: grasscutter.jar:com/mongodb/MongoBulkWriteException.class */
public class MongoBulkWriteException extends MongoServerException {
    private static final long serialVersionUID = -4345399805987210275L;
    private final BulkWriteResult writeResult;
    private final List<BulkWriteError> errors;
    private final ServerAddress serverAddress;
    private final WriteConcernError writeConcernError;

    @Deprecated
    public MongoBulkWriteException(BulkWriteResult writeResult, List<BulkWriteError> writeErrors, @Nullable WriteConcernError writeConcernError, ServerAddress serverAddress) {
        this(writeResult, writeErrors, writeConcernError, serverAddress, Collections.emptySet());
    }

    public MongoBulkWriteException(BulkWriteResult writeResult, List<BulkWriteError> writeErrors, @Nullable WriteConcernError writeConcernError, ServerAddress serverAddress, Set<String> errorLabels) {
        super("Bulk write operation error on server " + serverAddress + ". " + (writeErrors.isEmpty() ? "" : "Write errors: " + writeErrors + ". ") + (writeConcernError == null ? "" : "Write concern error: " + writeConcernError + ". "), serverAddress);
        this.writeResult = writeResult;
        this.errors = writeErrors;
        this.writeConcernError = writeConcernError;
        this.serverAddress = serverAddress;
        addLabels(errorLabels);
        if (writeConcernError != null) {
            addLabels(writeConcernError.getErrorLabels());
        }
    }

    public BulkWriteResult getWriteResult() {
        return this.writeResult;
    }

    public List<BulkWriteError> getWriteErrors() {
        return this.errors;
    }

    @Nullable
    public WriteConcernError getWriteConcernError() {
        return this.writeConcernError;
    }

    @Override // com.mongodb.MongoServerException
    public ServerAddress getServerAddress() {
        return this.serverAddress;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MongoBulkWriteException that = (MongoBulkWriteException) o;
        if (!this.errors.equals(that.errors) || !this.serverAddress.equals(that.serverAddress)) {
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
        return (31 * ((31 * ((31 * this.writeResult.hashCode()) + this.errors.hashCode())) + this.serverAddress.hashCode())) + (this.writeConcernError != null ? this.writeConcernError.hashCode() : 0);
    }
}
