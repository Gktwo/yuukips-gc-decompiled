package com.mongodb.bulk;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.NonNull;
import java.util.Collections;
import java.util.Set;
import org.bson.BsonDocument;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* loaded from: grasscutter.jar:com/mongodb/bulk/WriteConcernError.class */
public class WriteConcernError {
    private final int code;
    private final String codeName;
    private final String message;
    private final BsonDocument details;
    private final Set<String> errorLabels;

    public WriteConcernError(int code, String codeName, String message, BsonDocument details) {
        this(code, codeName, message, details, Collections.emptySet());
    }

    public WriteConcernError(int code, String codeName, String message, BsonDocument details, Set<String> errorLabels) {
        this.code = code;
        this.codeName = (String) Assertions.notNull("codeName", codeName);
        this.message = (String) Assertions.notNull(SendMailJob.PROP_MESSAGE, message);
        this.details = (BsonDocument) Assertions.notNull("details", details);
        this.errorLabels = (Set) Assertions.notNull("errorLabels", errorLabels);
    }

    public int getCode() {
        return this.code;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public String getMessage() {
        return this.message;
    }

    public BsonDocument getDetails() {
        return this.details;
    }

    public void addLabel(String errorLabel) {
        Assertions.notNull("errorLabel", errorLabel);
        this.errorLabels.add(errorLabel);
    }

    @NonNull
    public Set<String> getErrorLabels() {
        return Collections.unmodifiableSet(this.errorLabels);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WriteConcernError that = (WriteConcernError) o;
        if (this.code == that.code && this.codeName.equals(that.codeName) && this.details.equals(that.details) && this.message.equals(that.message) && this.errorLabels.equals(that.errorLabels)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * this.code) + this.codeName.hashCode())) + this.message.hashCode())) + this.details.hashCode())) + this.errorLabels.hashCode();
    }

    public String toString() {
        return "WriteConcernError{code=" + this.code + ", codeName='" + this.codeName + "', message='" + this.message + "', details=" + this.details + ", errorLabels=" + this.errorLabels + '}';
    }
}
