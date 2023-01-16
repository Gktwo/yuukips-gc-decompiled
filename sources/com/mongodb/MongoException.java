package com.mongodb;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/MongoException.class */
public class MongoException extends RuntimeException {
    public static final String TRANSIENT_TRANSACTION_ERROR_LABEL = "TransientTransactionError";
    public static final String UNKNOWN_TRANSACTION_COMMIT_RESULT_LABEL = "UnknownTransactionCommitResult";
    private static final long serialVersionUID = -4415279469780082174L;
    private final int code;
    private final Set<String> errorLabels;

    @Nullable
    public static MongoException fromThrowable(@Nullable Throwable t) {
        if (t == null) {
            return null;
        }
        return fromThrowableNonNull(t);
    }

    public static MongoException fromThrowableNonNull(Throwable t) {
        if (t instanceof MongoException) {
            return (MongoException) t;
        }
        return new MongoException(t.getMessage(), t);
    }

    public MongoException(String msg) {
        super(msg);
        this.errorLabels = new HashSet();
        this.code = -3;
    }

    public MongoException(int code, String msg) {
        super(msg);
        this.errorLabels = new HashSet();
        this.code = code;
    }

    public MongoException(String msg, Throwable t) {
        super(msg, t);
        this.errorLabels = new HashSet();
        this.code = -4;
    }

    public MongoException(int code, String msg, Throwable t) {
        super(msg, t);
        this.errorLabels = new HashSet();
        this.code = code;
        if (t instanceof MongoException) {
            addLabels(((MongoException) t).getErrorLabels());
        }
    }

    public MongoException(int code, String msg, BsonDocument response) {
        super(msg);
        this.errorLabels = new HashSet();
        this.code = code;
        addLabels(response.getArray("errorLabels", new BsonArray()));
    }

    public int getCode() {
        return this.code;
    }

    public void addLabel(String errorLabel) {
        Assertions.notNull("errorLabel", errorLabel);
        this.errorLabels.add(errorLabel);
    }

    public void removeLabel(String errorLabel) {
        Assertions.notNull("errorLabel", errorLabel);
        this.errorLabels.remove(errorLabel);
    }

    public Set<String> getErrorLabels() {
        return Collections.unmodifiableSet(this.errorLabels);
    }

    public boolean hasErrorLabel(String errorLabel) {
        Assertions.notNull("errorLabel", errorLabel);
        return this.errorLabels.contains(errorLabel);
    }

    protected void addLabels(BsonArray labels) {
        Iterator<BsonValue> it = labels.iterator();
        while (it.hasNext()) {
            addLabel(it.next().asString().getValue());
        }
    }

    protected void addLabels(Collection<String> labels) {
        for (String errorLabel : labels) {
            addLabel(errorLabel);
        }
    }
}
