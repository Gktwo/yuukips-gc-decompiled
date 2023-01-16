package com.mongodb;

import com.mongodb.assertions.Assertions;
import com.mongodb.bulk.WriteConcernError;
import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:com/mongodb/MongoWriteConcernException.class */
public class MongoWriteConcernException extends MongoServerException {
    private static final long serialVersionUID = 4577579466973523211L;
    private final WriteConcernError writeConcernError;
    private final WriteConcernResult writeConcernResult;

    public MongoWriteConcernException(WriteConcernError writeConcernError, ServerAddress serverAddress) {
        this(writeConcernError, null, serverAddress);
    }

    public MongoWriteConcernException(WriteConcernError writeConcernError, @Nullable WriteConcernResult writeConcernResult, ServerAddress serverAddress) {
        super(writeConcernError.getCode(), writeConcernError.getMessage(), serverAddress);
        this.writeConcernResult = writeConcernResult;
        this.writeConcernError = (WriteConcernError) Assertions.notNull("writeConcernError", writeConcernError);
        for (String errorLabel : writeConcernError.getErrorLabels()) {
            addLabel(errorLabel);
        }
    }

    @Override // com.mongodb.MongoException
    public void addLabel(String errorLabel) {
        this.writeConcernError.addLabel(errorLabel);
        addLabel(errorLabel);
    }

    public WriteConcernError getWriteConcernError() {
        return this.writeConcernError;
    }

    public WriteConcernResult getWriteResult() {
        return this.writeConcernResult;
    }
}
