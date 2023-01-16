package com.mongodb.bulk;

import com.mongodb.WriteError;
import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/bulk/BulkWriteError.class */
public class BulkWriteError extends WriteError {
    private final int index;

    public BulkWriteError(int code, String message, BsonDocument details, int index) {
        super(code, message, details);
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    @Override // com.mongodb.WriteError
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BulkWriteError that = (BulkWriteError) o;
        if (this.index != that.index) {
            return false;
        }
        return equals(that);
    }

    @Override // com.mongodb.WriteError
    public int hashCode() {
        return (31 * hashCode()) + this.index;
    }

    @Override // com.mongodb.WriteError
    public String toString() {
        return "BulkWriteError{index=" + this.index + ", code=" + getCode() + ", message='" + getMessage() + "', details=" + getDetails() + '}';
    }
}
