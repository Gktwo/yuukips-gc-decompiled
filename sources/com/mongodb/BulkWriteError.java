package com.mongodb;

import com.mongodb.assertions.Assertions;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* loaded from: grasscutter.jar:com/mongodb/BulkWriteError.class */
public class BulkWriteError {
    private final int index;
    private final int code;
    private final String message;
    private final DBObject details;

    public BulkWriteError(int code, String message, DBObject details, int index) {
        this.code = code;
        this.message = (String) Assertions.notNull(SendMailJob.PROP_MESSAGE, message);
        this.details = (DBObject) Assertions.notNull("details", details);
        this.index = index;
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

    public int getIndex() {
        return this.index;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BulkWriteError that = (BulkWriteError) o;
        if (this.code == that.code && this.index == that.index && this.details.equals(that.details) && this.message.equals(that.message)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * this.index) + this.code)) + this.message.hashCode())) + this.details.hashCode();
    }

    public String toString() {
        return "BulkWriteError{index=" + this.index + ", code=" + this.code + ", message='" + this.message + "', details=" + this.details + '}';
    }
}
