package com.mongodb;

import com.mongodb.assertions.Assertions;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* loaded from: grasscutter.jar:com/mongodb/WriteConcernError.class */
public class WriteConcernError {
    private final int code;
    private final String message;
    private final DBObject details;

    public WriteConcernError(int code, String message, DBObject details) {
        this.code = code;
        this.message = (String) Assertions.notNull(SendMailJob.PROP_MESSAGE, message);
        this.details = (DBObject) Assertions.notNull("details", details);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public DBObject getDetails() {
        return this.details;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WriteConcernError that = (WriteConcernError) o;
        if (this.code == that.code && this.details.equals(that.details) && this.message.equals(that.message)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((31 * this.code) + this.message.hashCode())) + this.details.hashCode();
    }

    public String toString() {
        return "BulkWriteConcernError{code=" + this.code + ", message='" + this.message + "', details=" + this.details + '}';
    }
}
